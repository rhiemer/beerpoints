package br.com.rhiemer.beerpoints.test.integration.exclude;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import br.com.rhiemer.api.jpa.builder.BuilderCriteriaJPA;
import br.com.rhiemer.api.jpa.criteria.builder.ParametroCriteriaJPADto;
import br.com.rhiemer.api.jpa.parametros.execucao.ExecucaoSemLazy;
import br.com.rhiemer.api.test.integration.testcategory.IntegrationTeste;
import br.com.rhiemer.api.test.unit.testcategory.ExcludeTeste;
import br.com.rhiemer.api.util.dao.parametros.execucao.ExecucaoAtributos;
import br.com.rhiemer.beerpoints.domain.enums.EnumEntidadeBeerPoints;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Cerveja;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Cerveja_;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Pais_;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cervejaria.Cervejaria;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cervejaria.Cervejaria_;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.controle.ControleEntidade;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.PaisLocalizacao_;
import br.com.rhiemer.beerpoints.service.cerveja.CervejaService;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;

@RunWith(Arquillian.class)
@UsingDataSet("testes/ListarCervejaTeste.xml")
@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_ROWS_ONLY)
@Transactional(TransactionMode.ROLLBACK)
public class TesteListarCerveja implements ExcludeTeste, IntegrationTeste {

	@Inject
	private CervejaService cervejaService;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment(TesteListarCerveja.class);
	}

	@Test
	public void testeRecuperarListaDeCervejas() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class)
				.parametrosExecucao(ExecucaoAtributos.builder()).build();
		List<Cerveja> cervejas = cervejaService.excutarQueryList(query);
		Assert.assertNotNull(cervejas);
		Assert.assertTrue(cervejas.size() > 0);
		Assert.assertNotNull(cervejas.get(0).getPais());
		Assert.assertNotNull(cervejas.get(0).getPais().getNome());
	}

	@Test
	public void testeRecuperarListaDeCervejasSemAtributos() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build();
		List<Cerveja> cervejas = cervejaService.excutarQueryList(query, ExecucaoSemLazy.builder());
		Assert.assertNotNull(cervejas);
		Assert.assertTrue(cervejas.size() > 0);
		Assert.assertNull(cervejas.get(0).getPais());
		Assert.assertNull(cervejas.get(0).getBares());
	}

	@Test
	public void testeRecuperarCervejaPrimaryKey() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build().primaryKey(-1);
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaPrimaryKeyEntity() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.primaryKey(new Cerveja(-1));
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query, ExecucaoSemLazy.builder());
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaPrimaryKeyEntityNot() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.primaryKeyNot(-1);
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNull(cerveja);
	}

	@Test
	public void testeRecuperarCervejaUniqueKey() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(ControleEntidade.class).build()
				.uniqueKeyByParams("Cervejaria", -1);
		ControleEntidade controleEntidade = (ControleEntidade) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(controleEntidade);
		Assert.assertEquals(controleEntidade.getId(), new Integer(-4));
	}

	@Test
	public void testeRecuperarCervejaUniqueKeyEnum() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(ControleEntidade.class).build()
				.uniqueKeyByParams(EnumEntidadeBeerPoints.getByNome("Cervejaria"), -1);
		ControleEntidade controleEntidade = (ControleEntidade) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(controleEntidade);
		Assert.assertEquals(controleEntidade.getId(), new Integer(-4));
	}

	@Test
	public void testeRecuperarCervejaEqualsCaseInsensitive() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.equal("nome", "cerveja teste ").root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaEqualAtribute() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.equalAtribute("cerveja teste ", Cerveja_.nome).root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaEqualCervejaria() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.equal("cervejaria", new Cervejaria(-1)).root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query, ExecucaoSemLazy.builder());
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
		Assert.assertNull(cerveja.getCervejaria());
	}

	@Test
	public void testeRecuperarCervejaEqualCervejariaIdFecth() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.equal("cervejaria", -1).root().fetch("cervejaria");
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query, ExecucaoSemLazy.builder());
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
		Assert.assertNotNull(cerveja.getCervejaria());
		Assert.assertEquals(cerveja.getCervejaria().getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaEqualCervejariaNome() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.equal("cervejaria.nome", "Cervejaria Teste").root().fetch("cervejaria");
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query, ExecucaoSemLazy.builder());
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
		Assert.assertNotNull(cerveja.getCervejaria());
		Assert.assertEquals(cerveja.getCervejaria().getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaEqualCervejariaNomeAtributo() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.equalAtribute("Cervejaria Teste", Cerveja_.cervejaria, Cervejaria_.nome).root().fetch("cervejaria");
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query, ExecucaoSemLazy.builder());
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
		Assert.assertNotNull(cerveja.getCervejaria());
		Assert.assertEquals(cerveja.getCervejaria().getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaEqualJuncaoOr() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build().and().or()
				.equal("cervejaria", -1).equal("cervejaria", -20000).equal("cervejaria.nome", "xxxxx").root();
		List<Cerveja> cervejas = cervejaService.excutarQueryList(query);
		Assert.assertNotNull(cervejas);
		Assert.assertTrue(cervejas.size() > 0);
		Assert.assertEquals(cervejas.get(0).getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaEqualJuncaoAndOr() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build().and().or()
				.equal("cervejaria", -1).equal("cervejaria", -20000).equal("cervejaria.nome", "xxxxx").anterior().and()
				.or().equal("estilo", -1).equal("estilo", -20000).root();
		List<Cerveja> cervejas = cervejaService.excutarQueryList(query);
		Assert.assertNotNull(cervejas);
		Assert.assertTrue(cervejas.size() > 0);
		Assert.assertEquals(cervejas.get(0).getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaEqualAtributeComplex() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.equalAtribute("1", Cerveja_.pais, Pais_.paisLocalizacao, PaisLocalizacao_.codigoIBGE).root()
				.fetch(Cerveja_.pais, Pais_.paisLocalizacao);
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
		Assert.assertNotNull(cerveja.getPais());
		Assert.assertNotNull(cerveja.getPais().getPaisLocalizacao());
		Assert.assertEquals(cerveja.getPais().getPaisLocalizacao().getCodigoIBGE(), new Integer(1));
	}

	@Test
	public void testeRecuperarCervejaEqualIsExpression() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.equal("cervejaria.id", new ParametroCriteriaJPADto().setIsExpression(true), "familia.id").root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaLike() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.like("nome", "cerveja").root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaILike() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.iLike("nome", "zzzz cerveja teste xxx cccc").root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaILikeQuoteString() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.iLike("nome", "zzzz \"cerveja dddkd\" xxx cccc").root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNull(cerveja);
	}

	@Test
	public void testeRecuperarCervejaILikeStringEqual() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.iLike("nome", "\"=Cerveja Teste\"").root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaNotEqual() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.notEqual("nome", "ggsfsf").root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaIn() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.in("id", -1, -2, -300, -1000000).root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaNotIn() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.notIn("id", -300, -1000000).root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaMaiorQue() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.maiorQue("id", -300).root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaMaiorQueOuIgual() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.maiorQueOuIgual("id", -1).root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaMenorQue() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.menorQue("id", 0).root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaMenorQueOuIgual() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.menorQueOuIgual("id", -1).root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaIsNull() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.isNull("exclusao").root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaIsNotNull() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build().isNotNull("id")
				.root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaBetween() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.between("id", -100000, -1).root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeRecuperarCervejaBetweenCampo() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(Cerveja.class).build()
				.betweenCampo("cervejaria.controleId", "pais.controleId", -5).root();
		Cerveja cerveja = (Cerveja) cervejaService.excutarQueryUniqueResult(query);
		Assert.assertNotNull(cerveja);
		Assert.assertEquals(cerveja.getId(), new Integer(-1));
	}

	@Test
	public void testeOrderByAsc() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(ControleEntidade.class).build()
				.orderBy("nome");
		List<ControleEntidade> controleEntidades = cervejaService.excutarQueryList(query);
		Assert.assertNotNull(controleEntidades);
		Assert.assertTrue(controleEntidades.size() > 0);
		Assert.assertNotNull(controleEntidades.get(0));
		Assert.assertEquals(controleEntidades.get(0).getId(), new Integer(-3));
	}

	@Test
	public void testeOrderByDesc() {
		BuilderCriteriaJPA query = BuilderCriteriaJPA.builderCreate().resultClass(ControleEntidade.class).build()
				.orderByDesc("nome");
		List<ControleEntidade> controleEntidades = cervejaService.excutarQueryList(query);
		Assert.assertNotNull(controleEntidades);
		Assert.assertTrue(controleEntidades.size() > 0);
		Assert.assertNotNull(controleEntidades.get(0));
		Assert.assertEquals(controleEntidades.get(0).getId(), new Integer(-8));
	}

}
