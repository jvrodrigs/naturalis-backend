package app.naturalis.backend.repository;

import app.naturalis.backend.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    public Optional<Funcionario> findByEmail(String email);
}
