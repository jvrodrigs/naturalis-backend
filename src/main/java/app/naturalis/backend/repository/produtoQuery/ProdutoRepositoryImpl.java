package app.naturalis.backend.repository.produtoQuery;

import app.naturalis.backend.model.Produto;
import app.naturalis.backend.repository.filter.ProdutoFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryImpl implements ProdutoRpositoryFilter{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Produto> filtrar(ProdutoFilter produtoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);
        Root<Produto> root = criteriaQuery.from(Produto.class);

        Predicate[] predicates = criarFiltro(produtoFilter, builder, root);
        criteriaQuery.where(predicates);

        TypedQuery<Produto> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Page<Produto> filtrarPaging(ProdutoFilter produtoFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);
        Root<Produto> root = criteriaQuery.from(Produto.class);

        Predicate[] predicates = criarFiltro(produtoFilter, builder, root);
        criteriaQuery.where(predicates);

        TypedQuery<Produto> query = manager.createQuery(criteriaQuery);
        int countRows = query.getResultList().size();

        query.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        Page<Produto> result = new PageImpl<>(query.getResultList(), pageable, countRows);
        return  result;
    }

    private Predicate[] criarFiltro(ProdutoFilter produtoFilter, CriteriaBuilder builder,
                                    Root<Produto> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(produtoFilter.getNome())){
            predicates.add(builder.like(builder.lower(root.get("nome")), "%" + produtoFilter.getNome().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(produtoFilter.getFabricante())){
            predicates.add(builder.like(builder.lower(root.get("fabricante")), "%" + produtoFilter.getFabricante().toLowerCase() + "%"));
        }

        if (!StringUtils.isEmpty(produtoFilter.getCodigoRef())){
            predicates.add(builder.like(builder.lower(root.get("codigoReferencia")), "%" + produtoFilter.getCodigoRef().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
