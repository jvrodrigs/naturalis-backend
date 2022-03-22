package app.naturalis.backend.repository.ordemServicoQuery;

import app.naturalis.backend.dto.OrdemServicoPorPessoaDto;
import app.naturalis.backend.model.OrdemServico;
import app.naturalis.backend.repository.filter.OrdemServicoFilter;

import java.util.List;

public interface OrdemServicoRepositoryFilter {

    List<OrdemServico> porPessoa(int id);
    List<OrdemServico> filtrarPorDia(OrdemServicoFilter ordemServicoFilter);
    List<OrdemServico> filtrar(OrdemServicoFilter ordemServicoFilter);
}
