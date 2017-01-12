package br.com.rhiemer.beerpoints.test.integration.servicos;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.hamcrest.Matcher;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;

import br.com.rhiemer.beerpoints.modelo.Fabricante;
import br.com.rhiemer.beerpoints.modelo.enums.EnumTipoFabricante;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;

public class TestIntegrationFabricanteService extends TestGenericEntidadeBeerPoints<Fabricante> {

	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment();
	}

	@Override
	public void carregarCampos(Fabricante entidade) {
		entidade.setTipoFabricante(EnumTipoFabricante.GRANDE);
	}

	@Override
	public void testarCamposBasicos(Fabricante entidadeNova, Fabricante entidade) {
		super.testarCamposBasicos(entidadeNova, entidade);
		assertNotNull(String.format("Tipo do Fabricante nulo - %s", fase), entidadeNova.getTipoFabricante());
		assertEquals(String.format("Tipo do fabricante diferente do incluido - %s", fase),
				entidadeNova.getTipoFabricante(), entidade.getTipoFabricante());
	}

	@Override
	public Matcher<Fabricante> matcherListaEntidade(Collection<Fabricante> listaEntidade, Fabricante entidadeTeste) {
		Matcher<Fabricante> matchers = allOf(hasProperty("id", notNullValue()),
				hasProperty("nome", not(isEmptyOrNullString())), hasProperty("tipoFabricante", notNullValue()),
				hasProperty("id", equalTo(entidadeTeste.getId())),
				hasProperty("tipoFabricante", equalTo(entidadeTeste.getTipoFabricante())),
				hasProperty("nome", equalTo(entidadeTeste.getNome())));

		return matchers;
	}

}
