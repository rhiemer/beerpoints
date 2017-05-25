package br.com.rhiemer.beerpoints.test.integration.exclude;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.rhiemer.api.test.integration.testcategory.IntegrationTeste;
import br.com.rhiemer.api.test.unit.testcategory.ExcludeTeste;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Cerveja;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Cerveja_;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Estilo;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Estilo_;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;

@RunWith(Arquillian.class)
@UsingDataSet("testes/ListarCervejaTeste.xml")
@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
@Transactional(TransactionMode.ROLLBACK)
public class TesteCriteriaJPASubQuery implements ExcludeTeste, IntegrationTeste {

	@Inject
	private EntityManager em;

	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment(TesteCriteriaJPASubQuery.class);
	}

	@Test
	public void testeCriteriaExists() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Estilo> query = criteriaBuilder.createQuery(Estilo.class);
		Root<Estilo> from = query.from(Estilo.class);

		Subquery<Cerveja> subquery = query.subquery(Cerveja.class);
		Root<Cerveja> subRootEntity = subquery.from(Cerveja.class);
		subquery.select(subRootEntity);

		List<Predicate> predicatesSubQuery = new ArrayList<Predicate>();
		predicatesSubQuery
				.add(criteriaBuilder.equal(subRootEntity.<Integer>get(Estilo_.id), from.<Integer>get(Cerveja_.id)));
		Expression<String> exp = subRootEntity.<String>get(Cerveja_.nome);
		predicatesSubQuery.add(criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.upper(exp), "%TESTE%")));
		subquery.where(predicatesSubQuery.toArray(new Predicate[] {}));

		List<Predicate> predicates = new ArrayList<Predicate>();
		predicates.add(criteriaBuilder.exists(subquery));
		

		TypedQuery<Estilo> typedQuery = em
				.createQuery(query.select(from).where(predicates.toArray(new Predicate[] {})));
		List<Estilo> lista = typedQuery.getResultList();
		Assert.assertNotNull(lista);
		Assert.assertTrue(lista.size() > 0);
		
		//subquery("cerveja","c").equalExists("root.id","estilo.id").equal().anterior().exists("c")
		//"/subQuery/Cerveja/c/equal/{root}.id/estilo.id/like/nome/Teste/anterior/exists/c"
		
		

	}

}
