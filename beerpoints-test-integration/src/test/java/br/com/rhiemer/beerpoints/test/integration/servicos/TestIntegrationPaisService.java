package br.com.rhiemer.beerpoints.test.integration.servicos;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Pais;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;


public class TestIntegrationPaisService extends TestGenericEntidadeBeerPoints<Pais> {
	
	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment();
	}

}
