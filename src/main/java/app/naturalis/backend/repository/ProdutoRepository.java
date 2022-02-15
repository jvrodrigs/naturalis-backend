package app.naturalis.backend.repository;

import app.naturalis.backend.model.Produto;
import app.naturalis.backend.repository.produtoQuery.ProdutoRpositoryFilter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>, ProdutoRpositoryFilter {
}
