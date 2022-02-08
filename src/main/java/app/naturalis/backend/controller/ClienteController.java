package app.naturalis.backend.controller;

import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.repository.ClienteRepository;
import app.naturalis.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getAll(){
        return this.clienteRepository.findAll();
    }
}
