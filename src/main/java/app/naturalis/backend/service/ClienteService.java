package app.naturalis.backend.service;

import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente newClient(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    public Optional<Cliente> getById(Long id){
        var clienteById = this.clienteRepository.findById(id);
        return clienteById;
   }
}
