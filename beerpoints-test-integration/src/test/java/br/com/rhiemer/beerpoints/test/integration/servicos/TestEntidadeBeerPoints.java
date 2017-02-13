package br.com.rhiemer.beerpoints.test.integration.servicos;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.api.test.integration.annotation.ServiceTestClientRest;
import br.com.rhiemer.api.test.integration.client.ClientTest;
import br.com.rhiemer.api.test.integration.testcategory.IntegrationTeste;
import br.com.rhiemer.api.util.helper.Helper;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreComIdIncrementalDeleteLogico;
import br.com.rhiemer.beerpoints.rest.resource.RestFullBeerPoints;

@RunWith(Arquillian.class)
public class TestEntidadeBeerPoints<T extends EntityBeerPointsCoreComIdIncrementalDeleteLogico> extends ClientTest
		implements IntegrationTeste {

	protected String identificador;
	protected Class<T> entidadeBeerPoints;
	protected String fase;
	protected T entidadeIncluida;
	protected T entidadeAlterada;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@ServiceTestClientRest
	protected RestFullBeerPoints rest;

	public TestEntidadeBeerPoints() {
		entidadeBeerPoints = Helper.getClassPrincipal(this.getClass());
		RESTful restFull = getEntidadeBeerPoints().getAnnotation(RESTful.class);
		if (restFull != null)
			identificador = restFull.value();
	}

	@Test
	@InSequence(1)
	@RunAsClient
	public void testePersistencieERecuperacaoServicoEntidade() {
		beforeTestePersistencieERecuperacaoServicoEntidade();
		testeInclusao();
		testeAlteracao();
	}

	@After
	public void testeDeletarEntidade() {
		if (entidadeIncluida != null) {
			fase = "Exclusão";
			removerEntidadeServico(entidadeIncluida.getId());
			expectedException.expect(isA(NotFoundException.class));
			buscarEntidadeServico(entidadeIncluida.getId());
			entidadeIncluida = null;
		}
	}

	@Test
	@InSequence(2)
	@RunAsClient
	public void testeIncluirEntidadeInvalida() {
		fase = "Inclusão inválida";
		T entidadeInvalida = criarEntidadeInvalidaParaInclusao();
		expectedException.expect(isA(BadRequestException.class));
		criarEntidadeServico(entidadeInvalida);
	}

	public void testeInclusao() {
		this.entidadeIncluida = null;
		this.fase = "Inclusão";
		T entidadeAIncluir = criarEntidade();
		this.entidadeIncluida = criarEntidadeServico(entidadeAIncluir);
		testarCamposInclusao(entidadeIncluida, entidadeAIncluir);
		T entidadeIncluidaRecuperada = buscarEntidadeServico(entidadeIncluida.getId());
		testarCamposBuscarEntidade(entidadeIncluidaRecuperada, entidadeAIncluir);
	}

	public void testeAlteracao() {
		this.entidadeAlterada = null;
		this.fase = "Alteração";
		beforeAlteracaoTestePersistencieERecuperacaoServicoEntidade();
		T entidadeAAlterar = criarEntidade();
		entidadeAAlterar.setId(entidadeIncluida.getId());
		this.entidadeAlterada = alterarEntidadeServico(entidadeAAlterar);
		testarCamposAlteracao(entidadeAlterada, entidadeIncluida, entidadeAAlterar);
		T entidadeAlteradaRecuperada = buscarEntidadeServico(entidadeIncluida.getId());
		testarCamposBuscarEntidade(entidadeAlteradaRecuperada, entidadeAAlterar);
	}

	public void beforeTestePersistencieERecuperacaoServicoEntidade() {

	}

	public void beforeAlteracaoTestePersistencieERecuperacaoServicoEntidade() {

	}

	@Override
	protected String getPath() {
		return "rest";
	}

	public <K extends EntityBeerPointsCoreComIdIncrementalDeleteLogico> K criarNovaInstanciaEntidade(Class<K> classe) {
		K entidade = null;
		try {
			entidade = classe.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public T criarEntidade() {
		T entidade = (T) criarNovaInstanciaEntidade(getEntidadeBeerPoints());
		carregarCampos(entidade);
		return entidade;
	}

	public T criarEntidadeInvalidaParaInclusao() {
		T entidade = null;
		try {
			entidade = getEntidadeBeerPoints().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public T criarEntidadeServico(T entidade) {
		Object objIncluido = rest.add(getIdentificador(), entidade);
		assertNotNull("Entidade Incluida", objIncluido);
		T entidadeIncluida = (T) objIncluido;
		return entidadeIncluida;
	}

	public T alterarEntidadeServico(T entidade) {
		Object objAlterado = rest.update(getIdentificador(), entidade);
		assertNotNull("Entidade Alterada", objAlterado);
		T entidadeAlterada = (T) objAlterado;
		return entidadeAlterada;
	}

	public T buscarEntidadeServico(Integer id) {
		Object objRecuperada = rest.find(getIdentificador(), id.toString());
		assertNotNull(String.format("Entidade Recuperada - %s", fase), objRecuperada);
		T entidadeRecuperada = (T) objRecuperada;
		return entidadeRecuperada;
	}

	public void removerEntidadeServico(Integer id) {
		rest.delete(getIdentificador(), id.toString());
	}

	public void testarCamposBasicos(T entidadeNova, T entidade) {
		assertNotNull(String.format("Id nulo - %s", fase), entidadeNova.getId());
	}

	public void testarCamposInclusao(T entidadeIncluida, T entidade) {
		testarCamposBasicos(entidadeIncluida, entidade);
	}

	public void testarCamposAlteracao(T entidadeAlterada, T entidadeNova, T entidade) {
		testarCamposBasicos(entidadeAlterada, entidade);
	}

	public void testarCamposBuscarEntidade(T entidadeRecuperada, T entidadeTeste) {
		testarCamposBasicos(entidadeRecuperada, entidadeTeste);
	}

	public void carregarCampos(T entidade) {

	}

	public String getIdentificador() {
		return identificador;
	}

	public Class<T> getEntidadeBeerPoints() {
		return entidadeBeerPoints;
	}

}
