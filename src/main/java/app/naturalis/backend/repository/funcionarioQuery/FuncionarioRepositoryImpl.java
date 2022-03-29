package app.naturalis.backend.repository.funcionarioQuery;

import app.naturalis.backend.model.Funcionario;
import app.naturalis.backend.repository.filter.FuncionarioFilter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositoryImpl  implements FuncionarioRepositoryFilter{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Funcionario> filtrar(FuncionarioFilter funcionarioFilter){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Funcionario> criteriaQuery = builder.createQuery(Funcionario.class);
        Root<Funcionario> root = criteriaQuery.from(Funcionario.class);

        Predicate[] predicates = criarRestricoes(funcionarioFilter, builder, root);

        criteriaQuery.where(predicates);

        TypedQuery<Funcionario> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    private Predicate[] criarRestricoes(FuncionarioFilter funcionarioFilter, CriteriaBuilder builder, Root<Funcionario> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(funcionarioFilter.getCargo())){
            predicates.add(builder.like(builder.lower(root.get("cargo").get("descricao")), "%" + funcionarioFilter.getCargo().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
