package app.naturalis.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.naturalis.backend.model.Cliente;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
