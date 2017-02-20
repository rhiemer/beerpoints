package br.com.rhiemer.beerpoints.test.integration.servicos.abstracts;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.UUID;

import org.hamcrest.Matcher;

import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreComIdIncrementalDeleteLogico;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;

public class TestGenericEntidadeBeerPoints<T extends EntityBeerPointsCoreModelo> extends TestEntidadeBeerPoints<T> {

	@Override
	public void testeInclusao() {
		super.testeInclusao();
		Collection<T> listaEntidadeIncluida = buscarEntidadePorNomeServico(entidadeIncluida.getNome());
		testarCamposBuscarEntidadePorNomeServico(listaEntidadeIncluida, entidadeIncluida);
	}

	@Override
	public void testeAlteracao() {
		super.testeAlteracao();
		Collection<T> listaEntidadeAlterada = buscarEntidadePorNomeServico(entidadeAlterada.getNome());
		testarCamposBuscarEntidadePorNomeServico(listaEntidadeAlterada, entidadeAlterada);
	}

	@Override
	public <K extends EntityBeerPointsCoreComIdIncrementalDeleteLogico> K criarNovaInstanciaEntidade(Class<K> classe) {
		K entidade = super.criarNovaInstanciaEntidade(classe);
		((EntityBeerPointsCoreModelo) entidade).setNome(UUID.randomUUID().toString().toUpperCase());
		return entidade;
	}

	public Collection<T> buscarEntidadePorNomeServico(String nome) {
		Object objRecuperada = rest.procurarPeloNomePaginado(getIdentificador(), nome.toLowerCase(), 1, 1);
		;
		assertNotNull(String.format("Lista de Entidade Recuperada por nome - %s", fase), objRecuperada);
		Collection<T> listaEntidadeRecuperada = (Collection<T>) objRecuperada;
		return listaEntidadeRecuperada;
	}

	@Override
	public void testarCamposBasicos(T entidadeNova, T entidade) {
		assertNotNull(String.format("Id nulo - %s", fase), entidadeNova.getId());
		assertNotNull(String.format("Nome nulo - %s", fase), entidadeNova.getNome());
		assertEquals(String.format("Nome diferente do incluido - %s", fase), entidadeNova.getNome(),
				entidade.getNome());
	}

	public void testarCamposBuscarEntidadePorNomeServico(Collection<T> listaEntidade, T entidadeTeste) {
		testarCamposListaEntidade(listaEntidade, entidadeTeste);
	}

	public void testarCamposListaEntidade(Collection<T> listaEntidade, T entidadeTeste) {
		assertThat(String.format("Validando retorno da consulta. - %s", fase), listaEntidade, not(empty()));

		Matcher<T> matchers = matcherListaEntidade(listaEntidade, entidadeTeste);

		assertThat(String.format("Validando dados do retorno da consulta. - %s", fase), listaEntidade,
				((Matcher) everyItem(matchers)));
	}

	public Matcher<T> matcherListaEntidade(Collection<T> listaEntidade, T entidadeTeste) {
		Matcher<T> matchers = allOf(hasProperty("id", notNullValue()), hasProperty("nome", not(isEmptyOrNullString())),
				hasProperty("id", equalTo(entidadeTeste.getId())),
				hasProperty("nome", equalTo(entidadeTeste.getNome())));

		return matchers;
	}

}
