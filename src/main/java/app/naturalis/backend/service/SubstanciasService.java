package app.naturalis.backend.service;

import app.naturalis.backend.mail.Mailer;
import app.naturalis.backend.model.Funcionario;
import app.naturalis.backend.model.Substancias;
import app.naturalis.backend.repository.FuncionarioRepository;
import app.naturalis.backend.repository.SubstanciasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SubstanciasService {

    private static final String DEST = "ADMINISTRADOR";
    private static final String CRON_VALUE_EVERY_MORNING = "0 0 6 * * *";
    private static final int FIXED_DELAY_VALUE_TEST = 1000 * 30 * 60;
    private static final Logger logger = LoggerFactory.getLogger(SubstanciasService.class);

    @Autowired
    private SubstanciasRepository substanciasRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private Mailer mailer;

//    @Scheduled(cron = CRON_VALUE_EVERY_MORNING)
    @Scheduled(fixedDelay = FIXED_DELAY_VALUE_TEST)
    public void notificationExpirationSubs() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (logger.isDebugEnabled())
            logger.debug("Começando a destribuir os e-mails referente as validades das substâncias. Data de hoje: {}", fmt.format(new Date()));

        List<Substancias> substancesExpired = substanciasRepository.
                findByDataValidadeLessThanEqual(new Date());
        if (substancesExpired.isEmpty()) {
            logger.info("Sem substâncias vencidas para enviar e-mails");
            return;
        }

        logger.info("Hoje, {}, existem {} substâncias fora do prazo de validade", fmt.format(new Date()), substancesExpired.size());

        List<Funcionario> funcIsAdmin = funcionarioRepository.
                findByCargoDescricao(DEST);
        if (funcIsAdmin.isEmpty()){
            logger.warn("Existem substâncias vencidas, porém o sistema não encontrou destinatários válidos");
            return;
        }

        mailer.sendAlertSubstancesExpired(substancesExpired, funcIsAdmin);

        logger.info("Envio de e-mails de aviso, concluído!");
    }

    public Substancias newSubst(Substancias substancias){
        return this.substanciasRepository.save(substancias);
    }

    public Optional<Substancias> getById(int id){
        Optional<Substancias> subsById = Optional.ofNullable(this.substanciasRepository.findById(id).orElseThrow( () ->
                new EmptyResultDataAccessException((1))));
        return subsById;
    }

    public void removeSubsById(int id){
        this.substanciasRepository.deleteById(id);
    }

    public Substancias editById(int id, Substancias substancias){
        Optional<Substancias> saveSubs = Optional.ofNullable(this.substanciasRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1)));
        BeanUtils.copyProperties(substancias, saveSubs.get(), "id");
        return this.substanciasRepository.save(saveSubs.get());
    }
}
