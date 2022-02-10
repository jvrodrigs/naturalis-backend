package app.naturalis.backend.repository;

import app.naturalis.backend.model.OrdemServico;
import app.naturalis.backend.repository.ordemServicoQuery.OrdemServicoRepositoryFilter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer>, OrdemServicoRepositoryFilter {
}
