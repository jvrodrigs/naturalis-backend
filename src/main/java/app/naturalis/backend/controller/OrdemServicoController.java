package app.naturalis.backend.controller;

import app.naturalis.backend.event.RecursoEvent;
import app.naturalis.backend.handler.NaturalisExceptionHandler;
import app.naturalis.backend.handler.exception.ClienteIsInativoException;
import app.naturalis.backend.model.OrdemServico;
import app.naturalis.backend.repository.filter.OrdemServicoFilter;
import app.naturalis.backend.repository.OrdemServicoRepository;
import app.naturalis.backend.service.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private OrdemService ordemService;

    @Autowired
    private ApplicationEventPublisher pubEvent;

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public List<OrdemServico> getAll(OrdemServicoFilter osFilter){
        return this.ordemServicoRepository.filtrar(osFilter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> orderGetById(@PathVariable("id") int id){
        Optional<OrdemServico> os = this.ordemService.getById(id);

        return os.isPresent() ? ResponseEntity.ok(os) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<OrdemServico> create(@Valid @RequestBody OrdemServico ordemServico, HttpServletResponse response){
        OrdemServico os = ordemService.newOs(ordemServico);
        pubEvent.publishEvent(new RecursoEvent(this, response, os.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(os);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<OrdemServico> editById(@PathVariable("id") int id, @Valid @RequestBody OrdemServico osRequest){
        var os = this.ordemService.editById(id, osRequest);
        return ResponseEntity.ok(os);
    }

    @ExceptionHandler( {ClienteIsInativoException.class} )
    public ResponseEntity<Object> handleClienteIsInativoException(ClienteIsInativoException ex, HttpServletResponse response){
        String msgUser = messageSource.getMessage("cliente.inexistente-ou-inativo", null, LocaleContextHolder.getLocale());
        String msgDev = ex.toString();
        List<NaturalisExceptionHandler.Erro> erros = Arrays.asList(new NaturalisExceptionHandler.Erro(msgUser, msgDev));
        return ResponseEntity.badRequest().body(erros);
    }


}