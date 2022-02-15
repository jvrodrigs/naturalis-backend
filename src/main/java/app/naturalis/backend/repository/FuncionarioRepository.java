package app.naturalis.backend.repository;

import app.naturalis.backend.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    public Optional<Funcionario> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "insert into funcionario_perm (funcionario_id,permissao_id) VALUES (:idFunc,:idPerm)", nativeQuery = true)
    void createRelationPermFunc(int idFunc, int idPerm);
}
