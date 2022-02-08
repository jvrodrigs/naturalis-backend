package app.naturalis.backend.service;

import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

}
