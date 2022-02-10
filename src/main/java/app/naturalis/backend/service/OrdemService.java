package app.naturalis.backend.service;

import app.naturalis.backend.handler.exception.ClienteIsInativoException;
import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.model.OrdemServico;
import app.naturalis.backend.repository.ClienteRepository;
import app.naturalis.backend.repository.OrdemServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdemService {

    @Autowired
    private OrdemServicoRepository osRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public OrdemServico newOs(OrdemServico ordemServico){
        Optional<Cliente> cliente = this.clienteRepository.findById(ordemServico.getCliente().getId());

        if (cliente.isEmpty() || cliente.get().isInativo()){
            throw new ClienteIsInativoException();
        }
        return this.osRepository.save(ordemServico);
    }

    public Optional<OrdemServico> getById(int id){
        Optional<OrdemServico> osById = Optional.ofNullable(this.osRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1)));
        return osById;
    }

    public OrdemServico editById(int id, OrdemServico ordemServico){
        Optional<OrdemServico> osByIdSave = Optional.ofNullable(this.osRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1)));
        BeanUtils.copyProperties(ordemServico, osByIdSave.get(), "id");
        return this.osRepository.save(osByIdSave.get());
    }

    public void removeOsById(int id){
        this.osRepository.deleteById(id);
    }
}
