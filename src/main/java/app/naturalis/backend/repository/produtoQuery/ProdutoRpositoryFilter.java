package app.naturalis.backend.repository.produtoQuery;

import app.naturalis.backend.model.Produto;
import app.naturalis.backend.repository.filter.ProdutoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProdutoRpositoryFilter {

   List<Produto> filtrar(ProdutoFilter produtoFilter);

   Page<Produto> filtrarPaging(ProdutoFilter produtoFilter, Pageable pageable);
}
