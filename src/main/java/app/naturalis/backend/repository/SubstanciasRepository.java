package app.naturalis.backend.repository;

import app.naturalis.backend.model.Substancias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubstanciasRepository extends JpaRepository<Substancias, Integer> {
}
