package br.com.rhiemer.beerpoints.test.integration.exclude;

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

import br.com.rhiemer.api.test.integration.testcategory.IntegrationTeste;
import br.com.rhiemer.api.test.unit.testcategory.ExcludeTeste;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Pais;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.PaisLocalizacao;
import br.com.rhiemer.beerpoints.service.cerveja.PaisService;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;

@RunWith(Arquillian.class)
public class TesteIncluirPaisLocalizacao implements ExcludeTeste, IntegrationTeste {

	@Inject
	private PaisService paisService;

	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment(TesteIncluirPaisLocalizacao.class);
	}

	@Test
	@UsingDataSet("CadastrarPaisLocalizacao.xml")
	@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
	@Transactional(TransactionMode.ROLLBACK)
	public void testeRecuperarDecisaoComProcessoInexistenteDeveLevantarRegraDeNegocioException() throws Exception {
		PaisLocalizacao paisLocalizacao = new PaisLocalizacao();
		paisLocalizacao.setId(-1);
		Pais pais = new Pais();
		pais.setNome("Pais Teste");
		pais.setPaisLocalizacao(paisLocalizacao);
		Pais paisInserido = (Pais) paisService.adicionar(pais);
		Assert.assertNotNull(paisInserido);
	}

}
