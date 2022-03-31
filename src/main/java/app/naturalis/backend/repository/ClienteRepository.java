package app.naturalis.backend.repository;

import app.naturalis.backend.repository.ClienteQuery.ClienteRepositoryFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import app.naturalis.backend.model.Cliente;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>, ClienteRepositoryFilter {
}
