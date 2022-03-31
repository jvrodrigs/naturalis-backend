package app.naturalis.backend.repository.ClienteQuery;

import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.repository.filter.ClienteFilter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.Typed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepositoryFilter {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);

        Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
        criteriaQuery.where(predicates);

        TypedQuery<Cliente> query = manager.createQuery(criteriaQuery);
        int countRowsClient = query.getResultList().size();
        query.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());

        Page<Cliente> result = new PageImpl<>(query.getResultList(), pageable, countRowsClient);
        return result;
    }

    private Predicate[] criarRestricoes(ClienteFilter clienteFilter,
                                        CriteriaBuilder builder,
                                        Root<Cliente> root){
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(clienteFilter.getNome())){
            predicates.add(builder.like(builder.lower(root.get("nome")), "%" + clienteFilter.getNome().toLowerCase() + "%"));
        }

        if (clienteFilter.isAtivo()){
            predicates.add(builder.equal(root.get("ativo"), clienteFilter.isAtivo()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
