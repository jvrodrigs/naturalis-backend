package app.naturalis.backend.service;

import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente newClient(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    public Optional<Cliente> getById(int id){
        Optional<Cliente> clienteById = Optional.ofNullable(this.clienteRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1)));
        return clienteById;
   }

    public Cliente editById(int id, Cliente cliente){
        Optional<Cliente> saveClient = Optional.ofNullable(this.clienteRepository.findById(id).orElseThrow( () -> new EmptyResultDataAccessException((1))));
        BeanUtils.copyProperties(cliente, saveClient.get(), "id");
        return this.clienteRepository.save(saveClient.get());
    }

   public void updateActive(int id, Boolean ativo){
        Optional<Cliente> cliente = Optional.ofNullable(this.clienteRepository.findById(id).orElseThrow( () -> new EmptyResultDataAccessException((1))));
        cliente.get().setAtivo(ativo);
        this.clienteRepository.save(cliente.get());
   }

    public void removeClintById(int id){
        this.clienteRepository.deleteById(id);
    }
}
