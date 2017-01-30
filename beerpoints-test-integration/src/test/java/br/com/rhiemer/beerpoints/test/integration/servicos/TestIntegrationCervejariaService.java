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

import br.com.rhiemer.beerpoints.modelo.entidades.Cervejaria;
import br.com.rhiemer.beerpoints.modelo.enums.EnumTipoCervejaria;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;

public class TestIntegrationCervejariaService extends TestGenericEntidadeBeerPoints<Cervejaria> {

	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment();
	}

	@Override
	public void carregarCampos(Cervejaria entidade) {
		entidade.setTipoCervejaria(EnumTipoCervejaria.GRANDE);
	}

	@Override
	public void testarCamposBasicos(Cervejaria entidadeNova, Cervejaria entidade) {
		super.testarCamposBasicos(entidadeNova, entidade);
		assertNotNull(String.format("Tipo da Cervejaria nulo - %s", fase), entidadeNova.getTipoCervejaria());
		assertEquals(String.format("Tipo do Cervejaria diferente do incluido - %s", fase),
				entidadeNova.getTipoCervejaria(), entidade.getTipoCervejaria());
	}

	@Override
	public Matcher<Cervejaria> matcherListaEntidade(Collection<Cervejaria> listaEntidade, Cervejaria entidadeTeste) {
		Matcher<Cervejaria> matchers = allOf(hasProperty("id", notNullValue()),
				hasProperty("nome", not(isEmptyOrNullString())), hasProperty("tipoCervejaria", notNullValue()),
				hasProperty("id", equalTo(entidadeTeste.getId())),
				hasProperty("tipoCervejaria", equalTo(entidadeTeste.getTipoCervejaria())),
				hasProperty("nome", equalTo(entidadeTeste.getNome())));

		return matchers;
	}

}
