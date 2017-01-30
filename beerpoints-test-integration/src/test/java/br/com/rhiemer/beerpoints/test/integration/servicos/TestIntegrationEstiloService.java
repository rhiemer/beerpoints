package br.com.rhiemer.beerpoints.test.integration.servicos;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;

import br.com.rhiemer.beerpoints.modelo.entidades.Estilo;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;


public class TestIntegrationEstiloService extends TestGenericEntidadeBeerPoints<Estilo> {
	
	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment();
	}

}
