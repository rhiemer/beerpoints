package br.com.rhiemer.beerpoints.test.integration.servicos.localizacao;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;

import br.com.rhiemer.api.test.integration.dbunit.annotations.DbUnitAdicionarArquivo;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Pais;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.PaisLocalizacao;
import br.com.rhiemer.beerpoints.test.integration.servicos.abstracts.TestGenericEntidadeBeerPoints;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;


@DbUnitAdicionarArquivo("CadastrarPaisLocalizacao.xml")
public class TestIntegrationPaisService extends TestGenericEntidadeBeerPoints<Pais> {

	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment();
	}
	
	
	@Override
	public void carregarCampos(Pais entidade) {
		entidade.setPaisLocalizacao(new PaisLocalizacao(new Integer(-1)));
	}
	
	


}
