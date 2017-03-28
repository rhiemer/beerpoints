package br.com.rhiemer.beerpoints.test.integration.exclude;

import java.util.List;

import javax.inject.Inject;

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

import br.com.rhiemer.api.jpa.builder.BuilderCriteriaJPA;
import br.com.rhiemer.api.test.integration.testcategory.IntegrationTeste;
import br.com.rhiemer.api.test.unit.testcategory.ExcludeTeste;
import br.com.rhiemer.api.util.dao.parametros.execucao.ExecucaoAtributos;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Cerveja;
import br.com.rhiemer.beerpoints.service.cerveja.CervejaService;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;

@RunWith(Arquillian.class)
public class TesteListarCerveja implements ExcludeTeste, IntegrationTeste {

	@Inject
	private CervejaService cervejaService;

	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment(TesteListarCerveja.class);
	}

	@Test
	@UsingDataSet("testes/ListarCervejaTeste.xml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	@Transactional(TransactionMode.ROLLBACK)
	public void testeRecuperarListaDeCervejas() throws Exception {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).parametrosExecucao(ExecucaoAtributos.builder()).build();
		List<Cerveja> cervejas = cervejaService.excutarQueryList(query);
		Assert.assertNotNull(cervejas);
	}

}
