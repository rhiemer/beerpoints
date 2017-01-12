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
import org.junit.After;

import br.com.rhiemer.beerpoints.modelo.Cerveja;
import br.com.rhiemer.beerpoints.modelo.Estilo;
import br.com.rhiemer.beerpoints.modelo.Fabricante;
import br.com.rhiemer.beerpoints.modelo.Pais;
import br.com.rhiemer.beerpoints.modelo.enums.EnumTipoFabricante;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;

public class TestIntegrationCervejaService extends TestGenericEntidadeBeerPoints<Cerveja> {

	private Pais pais;
	private Estilo estilo;
	private Fabricante fabricante;

	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment();
	}

	@Override
	public void beforeTestePersistencieERecuperacaoServicoEntidade() {
		fase = "Inclusão Entidades Auxiliares";

		Pais pais = criarNovaInstanciaEntidade(Pais.class);
		this.pais = (Pais) rest.add("Pais", pais);

		Estilo estilo = criarNovaInstanciaEntidade(Estilo.class);
		this.estilo = (Estilo) rest.add("Estilo", estilo);

		Fabricante fabricante = criarNovaInstanciaEntidade(Fabricante.class);
		fabricante.setTipoFabricante(EnumTipoFabricante.GRANDE);
		this.fabricante = (Fabricante) rest.add("Fabricante", fabricante);

	}

	@Override
	public void carregarCampos(Cerveja entidade) {
		entidade.setPais(pais);
		entidade.setEstilo(estilo);
		entidade.setFabricante(fabricante);
		entidade.setTeorAlcolico(new BigDecimal("5.55"));
	}

	@Override
	public void testarCamposBasicos(Cerveja entidadeNova, Cerveja entidade) {
		super.testarCamposBasicos(entidadeNova, entidade);
		assertNotNull(String.format("Pais da cerveja nula - %s", fase), entidadeNova.getPais());
		assertNotNull(String.format("Estilo da cerveja nulo - %s", fase), entidadeNova.getEstilo());
		assertNotNull(String.format("Fabricante da cerveja nulo - %s", fase), entidadeNova.getFabricante());
		assertNotNull(String.format("Teor alcolico da cerveja nulo - %s", fase), entidadeNova.getTeorAlcolico());

		assertEquals(String.format("Teor alcolico diferente do incluido - %s", fase), entidadeNova.getTeorAlcolico(),
				entidade.getTeorAlcolico());
		assertEquals(String.format("Pais da cerveja diferente do incluido - %s", fase), entidadeNova.getPais(),
				entidade.getPais());
		assertEquals(String.format("Estilo da cerveja diferente do incluido - %s", fase), entidadeNova.getEstilo(),
				entidade.getEstilo());
		assertEquals(String.format("Fabricante da cerveja diferente do incluido - %s", fase),
				entidadeNova.getFabricante(), entidade.getFabricante());
	}
	
	@Override
	public void testarCamposAlteracao(Cerveja entidadeAlterada,Cerveja entidadeNova,Cerveja entidade) {
		
	}

	@Override
	public Matcher<Cerveja> matcherListaEntidade(Collection<Cerveja> listaEntidade, Cerveja entidadeTeste) {
		Matcher<Cerveja> matchers = allOf(hasProperty("id", notNullValue()),
				hasProperty("nome", not(isEmptyOrNullString())), hasProperty("teorAlcolico", notNullValue()),
				hasProperty("id", equalTo(entidadeTeste.getId())),
				hasProperty("nome", equalTo(entidadeTeste.getNome())),
				hasProperty("teorAlcolico", equalTo(entidadeTeste.getTeorAlcolico()))
		);

		return matchers;
	}

	@After
	public void testeDeletarEntidadesAuxiliares() {
		if (pais != null) {
			rest.delete("Pais", pais.getId().toString());
			pais = null;
		}
		if (estilo != null) {
			rest.delete("Estilo", estilo.getId().toString());
			estilo = null;
		}
		if (fabricante != null) {
			rest.delete("Fabricante", fabricante.getId().toString());
			fabricante = null;
		}

	}

}
