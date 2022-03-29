package app.naturalis.backend.repository.ordemServicoQuery;

import app.naturalis.backend.dto.OrdemServicoPorPessoaDto;
import app.naturalis.backend.model.OrdemServico;
import app.naturalis.backend.repository.filter.OrdemServicoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrdemServicoRepositoryFilter {

    List<OrdemServico> porPessoa(int id);
    List<OrdemServico> filtrarPorDia(OrdemServicoFilter ordemServicoFilter);

    Page<OrdemServico> filtrar(OrdemServicoFilter ordemServicoFilter, Pageable page);

    List<OrdemServico> filtrarReport(OrdemServicoFilter ordemServicoFilter);
}
