package app.naturalis.backend.controller;

import app.naturalis.backend.event.RecursoEvent;
import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.repository.ClienteRepository;
import app.naturalis.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ApplicationEventPublisher pubEvent;

    @GetMapping
    public List<Cliente> getAll(){
        return this.clienteRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente, HttpServletResponse response){
        Cliente novoCliente = clienteService.newClient(cliente);

        pubEvent.publishEvent(new RecursoEvent(this, response, novoCliente.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        var cliente = this.clienteService.getById(id);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }
}
