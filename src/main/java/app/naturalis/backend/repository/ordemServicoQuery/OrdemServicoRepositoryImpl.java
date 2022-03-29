package app.naturalis.backend.repository.ordemServicoQuery;

import app.naturalis.backend.model.OrdemServico;
import app.naturalis.backend.repository.filter.OrdemServicoFilter;
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

public class OrdemServicoRepositoryImpl implements OrdemServicoRepositoryFilter{

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<OrdemServico> porPessoa(int id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<OrdemServico> criteriaQuery = builder.createQuery(OrdemServico.class);

        Root<OrdemServico> root = criteriaQuery.from(OrdemServico.class);

        List<Predicate> predicates = new ArrayList<>();
        Integer idOrder = id;

        if (idOrder != null){
            predicates.add(builder.equal(root.get("responsavel").get("id"), idOrder));
        }

        if (!predicates.isEmpty()){
            criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        }

        TypedQuery<OrdemServico> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public List<OrdemServico> filtrarPorDia(OrdemServicoFilter ordemServicoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<OrdemServico> criteriaQuery = builder.createQuery(OrdemServico.class);
        Root<OrdemServico> root = criteriaQuery.from(OrdemServico.class);

        List<Predicate> predicates = new ArrayList<>();

        if (ordemServicoFilter.getDataCriacaoDe() != null){
            predicates.add(builder.equal(root.get("dataCriado"), ordemServicoFilter.getDataCriacaoDe()));
        }

        if (!predicates.isEmpty()){
            criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        }

        TypedQuery<OrdemServico> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Page<OrdemServico> filtrar(OrdemServicoFilter ordemServicoFilter, Pageable paging) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<OrdemServico> criteriaQuery = builder.createQuery(OrdemServico.class);
        Root<OrdemServico> root = criteriaQuery.from(OrdemServico.class);

        Predicate[] predicates = criarRestricoes(ordemServicoFilter, builder, root);
        criteriaQuery.where(predicates);
        TypedQuery<OrdemServico> query = manager.createQuery(criteriaQuery);
        int countRows = query.getResultList().size();
        query.setFirstResult((paging.getPageNumber() - 1) * paging.getPageSize());
        query.setMaxResults(paging.getPageSize());
        Page<OrdemServico> result = new PageImpl<OrdemServico>(query.getResultList(), paging, countRows);
        return result;
    }

    @Override
    public List<OrdemServico> filtrarReport(OrdemServicoFilter ordemServicoFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<OrdemServico> criteriaQuery = builder.createQuery(OrdemServico.class);

        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        countQuery.select(builder.count(countQuery.from(OrdemServico.class)));
        Long count = manager.createQuery(countQuery).getSingleResult();

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

        if (ordemServicoFilter.getResp() != 0){
            predicates.add(builder.equal(root.get("responsavel").get("id"), ordemServicoFilter.getResp()));
        }

        if(ordemServicoFilter.getAutor() != 0){
            predicates.add(builder.equal(root.get("autor").get("id"), ordemServicoFilter.getAutor()));
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
