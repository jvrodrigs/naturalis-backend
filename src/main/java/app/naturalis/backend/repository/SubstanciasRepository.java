package app.naturalis.backend.repository;

import app.naturalis.backend.model.Substancias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SubstanciasRepository extends JpaRepository<Substancias, Integer> {

    List<Substancias> findByDataValidadeLessThanEqual(Date data);
}
