package app.naturalis.backend.repository.ordemServicoQuery;

import app.naturalis.backend.model.OrdemServico;
import app.naturalis.backend.repository.filter.OrdemServicoFilter;

import java.util.List;

public interface OrdemServicoRepositoryFilter {

    public List<OrdemServico> filtrar(OrdemServicoFilter ordemServicoFilter);
}