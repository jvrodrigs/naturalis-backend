package app.naturalis.backend.repository.ordemServicoQuery;

import app.naturalis.backend.model.OrdemServico;
import app.naturalis.backend.repository.filter.OrdemServicoFilter;
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

public class OrdemServicoRepositoryImpl implements OrdemServicoRepositoryFilter{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<OrdemServico> filtrar(OrdemServicoFilter ordemServicoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<OrdemServico> criteriaQuery = builder.createQuery(OrdemServico.class);
        Root<OrdemServico> root = criteriaQuery.from(OrdemServico.class);

        Predicate[] predicates = criarRestricoes(ordemServicoFilter, builder, root);
        criteriaQuery.where(predicates);

        TypedQuery<OrdemServico> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    private Predicate[] criarRestricoes(OrdemServicoFilter ordemServicoFilter, CriteriaBuilder builder,
                                        Root<OrdemServico> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(ordemServicoFilter.getDescricao())){
            predicates.add(builder.like(builder.lower(root.get("descricao")), "%" + ordemServicoFilter.getDescricao().toLowerCase() + "%"));
        }

        if (ordemServicoFilter.getDataCriacaoDe() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("dataCriado"), ordemServicoFilter.getDataCriacaoDe()));
        }

        if (ordemServicoFilter.getDataCriacaoAte() != null){
            predicates.add(builder.lessThanOrEqualTo(root.get("dataCriado"), ordemServicoFilter.getDataCriacaoAte()));
        }

        if (!StringUtils.isEmpty(ordemServicoFilter.getValorTotalDe())){
            predicates.add(builder.greaterThanOrEqualTo(root.get("valorTotal"), ordemServicoFilter.getValorTotalDe()));
        }

        if (!StringUtils.isEmpty(ordemServicoFilter.getValorTotalAte())){
            predicates.add(builder.lessThanOrEqualTo(root.get("valorTotal"), ordemServicoFilter.getValorTotalAte()));
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
