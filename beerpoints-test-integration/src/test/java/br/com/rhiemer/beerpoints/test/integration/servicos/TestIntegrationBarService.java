package br.com.rhiemer.beerpoints.test.integration.servicos;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

import java.util.Collection;

import org.hamcrest.Matcher;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;

import br.com.rhiemer.beerpoints.modelo.entidades.Bar;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;

public class TestIntegrationBarService extends TestGenericEntidadeBeerPoints<Bar> {

	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment();
	}

	@Override
	public void carregarCampos(Bar entidade) {

	}

	@Override
	public void testarCamposBasicos(Bar entidadeNova, Bar entidade) {
		super.testarCamposBasicos(entidadeNova, entidade);

	}

	@Override
	public Matcher<Bar> matcherListaEntidade(Collection<Bar> listaEntidade, Bar entidadeTeste) {
		Matcher<Bar> matchers = allOf(hasProperty("id", notNullValue()),
				hasProperty("nome", not(isEmptyOrNullString())), hasProperty("id", equalTo(entidadeTeste.getId())),
				hasProperty("nome", equalTo(entidadeTeste.getNome()))

		);

		return matchers;
	}

}
