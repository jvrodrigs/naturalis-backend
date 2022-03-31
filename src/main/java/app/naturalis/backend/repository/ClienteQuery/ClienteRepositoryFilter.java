package app.naturalis.backend.repository.ClienteQuery;

import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteRepositoryFilter {

    Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}
