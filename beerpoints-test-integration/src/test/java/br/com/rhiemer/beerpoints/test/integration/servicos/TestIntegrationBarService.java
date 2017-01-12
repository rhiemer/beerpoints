package br.com.rhiemer.beerpoints.test.integration.servicos;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Collection;

import org.hamcrest.Matcher;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;

import br.com.rhiemer.beerpoints.modelo.Bar;
import br.com.rhiemer.beerpoints.modelo.Localizacao;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;

public class TestIntegrationBarService extends TestGenericEntidadeBeerPoints<Bar> {

	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment();
	}

	@Override
	public void carregarCampos(Bar entidade) {
		entidade.setLocalizacao(new Localizacao());
		entidade.getLocalizacao().setLatitude(new BigDecimal("100.999999"));
		entidade.getLocalizacao().setLongitude(new BigDecimal("200.888888"));
	}

	@Override
	public void testarCamposBasicos(Bar entidadeNova, Bar entidade) {
		super.testarCamposBasicos(entidadeNova, entidade);
		assertNotNull(String.format("Localizacao do Bar nula - %s", fase), entidadeNova.getLocalizacao());
		assertNotNull(String.format("Latitude do Bar nula - %s", fase), entidadeNova.getLocalizacao().getLatitude());
		assertNotNull(String.format("Longitude do Bar nula - %s", fase), entidadeNova.getLocalizacao().getLongitude());
		assertEquals(String.format("Latitude do Bar diferente da incluida - %s", fase),
				entidadeNova.getLocalizacao().getLatitude(), entidade.getLocalizacao().getLatitude());
		assertEquals(String.format("Longitudde do Bar diferente da incluida - %s", fase),
				entidadeNova.getLocalizacao().getLongitude(), entidade.getLocalizacao().getLongitude());
	}

	@Override
	public Matcher<Bar> matcherListaEntidade(Collection<Bar> listaEntidade, Bar entidadeTeste) {
		Matcher<Bar> matchers = allOf(hasProperty("id", notNullValue()),
				hasProperty("nome", not(isEmptyOrNullString())), hasProperty("localizacao", notNullValue()),
				hasProperty("id", equalTo(entidadeTeste.getId())),
				hasProperty("nome", equalTo(entidadeTeste.getNome())), hasProperty("localizacao", allOf(
						hasProperty("latitude", notNullValue()), hasProperty("longitude", notNullValue()),
						hasProperty("latitude", equalTo(entidadeTeste.getLocalizacao().getLatitude())),
						hasProperty("longitude", equalTo(entidadeTeste.getLocalizacao().getLongitude()))

				)));

		return matchers;
	}

}
