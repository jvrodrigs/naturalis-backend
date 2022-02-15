package app.naturalis.backend.repository.produtoQuery;

import app.naturalis.backend.model.Produto;
import app.naturalis.backend.repository.filter.ProdutoFilter;

import java.util.List;

public interface ProdutoRpositoryFilter {

    public List<Produto> filtrar(ProdutoFilter produtoFilter);
}
