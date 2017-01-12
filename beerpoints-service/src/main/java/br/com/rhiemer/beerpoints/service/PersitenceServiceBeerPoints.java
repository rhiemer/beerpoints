package br.com.rhiemer.beerpoints.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.rhiemer.api.jpa.builder.BuilderCriteria;
import br.com.rhiemer.api.jpa.builder.BuilderCriteriaPredicate;
import br.com.rhiemer.api.jpa.builder.ParametrizarCriteria;
import br.com.rhiemer.api.jpa.service.PersistenceServiceAplicacao;
import br.com.rhiemer.api.util.dto.Pager;
import br.com.rhiemer.beerpoints.modelo.GenericEntityBeerPoints;

public class PersitenceServiceBeerPoints<T extends GenericEntityBeerPoints,K extends Serializable> extends PersistenceServiceAplicacao<T, K> {

	
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public <T extends GenericEntityBeerPoints> List<T> pesquisarPeloNome(String nome) {
		return pesquisarPeloNomePaginada(nome, 0, 0);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public <T extends GenericEntityBeerPoints> List<T> pesquisarPeloNomePaginada(String nome, int firstResult,
			int maxResult) {

		BuilderCriteria buildCriteria = BuilderCriteria.builder().parametrizarCriteria(new ParametrizarCriteria() {

			@Override
			public CriteriaQuery parametrizar(CriteriaBuilder builder, CriteriaQuery query, Root from,
					List<Predicate> predicates) {

				BuilderCriteriaPredicate.build(predicates).iLikeCaseInsensitive(builder, from.<String>get("nome"),
						nome);
				return query.orderBy(builder.asc(from.get("nome")));

			}
		}).pager(new Pager(firstResult, maxResult)).build();
		return excutarTypeQueryList(buildCriteria);
	}
}
