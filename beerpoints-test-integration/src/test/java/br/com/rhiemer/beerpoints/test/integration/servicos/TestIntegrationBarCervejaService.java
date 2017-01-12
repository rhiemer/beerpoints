package br.com.rhiemer.beerpoints.test.integration.servicos;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.UUID;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;

import br.com.rhiemer.beerpoints.modelo.Bar;
import br.com.rhiemer.beerpoints.modelo.BarCerveja;
import br.com.rhiemer.beerpoints.modelo.Cerveja;
import br.com.rhiemer.beerpoints.modelo.Estilo;
import br.com.rhiemer.beerpoints.modelo.Fabricante;
import br.com.rhiemer.beerpoints.modelo.GenericEntityBeerPoints;
import br.com.rhiemer.beerpoints.modelo.Pais;
import br.com.rhiemer.beerpoints.modelo.enums.EnumTipoFabricante;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;

public class TestIntegrationBarCervejaService extends TestEntidadeBeerPoints<BarCerveja> {

	private Pais pais;
	private Estilo estilo;
	private Fabricante fabricante;
	private Cerveja cerveja;
	private Bar bar;
	private BigDecimal precoMedioCerveja=new BigDecimal("99.99");

	@Deployment
	public static Archive<?> createTestableDeployment() {

		return BeerPointstWSUtilsArquillian.gerarDeployment();
	}

	@Override
	public void beforeTestePersistencieERecuperacaoServicoEntidade() {
		fase = "Inclusão Entidades Auxiliares";

		Pais pais = criarGenericEntityBeerPoints(Pais.class);
		this.pais = (Pais) rest.add("Pais", pais);

		Estilo estilo = criarGenericEntityBeerPoints(Estilo.class);
		this.estilo = (Estilo) rest.add("Estilo", estilo);

		Fabricante fabricante = criarGenericEntityBeerPoints(Fabricante.class);
		fabricante.setTipoFabricante(EnumTipoFabricante.GRANDE);
		this.fabricante = (Fabricante) rest.add("Fabricante", fabricante);

		Cerveja cerveja = criarGenericEntityBeerPoints(Cerveja.class);
		cerveja.setPais(this.pais);
		cerveja.setEstilo(this.estilo);
		cerveja.setFabricante(this.fabricante);
		this.cerveja = (Cerveja) rest.add("Cerveja", cerveja);

		Bar bar = criarGenericEntityBeerPoints(Bar.class);		
		this.bar = (Bar) rest.add("Bar", bar);

	}

	public <K extends GenericEntityBeerPoints> K criarGenericEntityBeerPoints(Class<K> classe) {
		K entidade = null;
		try {
			entidade = classe.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		entidade.setNome(UUID.randomUUID().toString().toUpperCase());
		return entidade;
	}
	
	@Override
	public void beforeAlteracaoTestePersistencieERecuperacaoServicoEntidade() {
		this.precoMedioCerveja=new BigDecimal("999.99");
	}
	
	@Override
	public void carregarCampos(BarCerveja entidade) {
		entidade.setBar(this.bar);
		entidade.setCerveja(this.cerveja);
		entidade.setPreco(this.precoMedioCerveja);
	}

	@Override
	public void testarCamposBasicos(BarCerveja entidadeNova, BarCerveja entidade) {
		super.testarCamposBasicos(entidadeNova, entidade);
		assertNotNull(String.format("Preco nulo - %s", fase), entidadeNova.getPreco());
		assertNotNull(String.format("Cerveja nula - %s", fase), entidadeNova.getCerveja());
		assertNotNull(String.format("Bar nulo - %s", fase), entidadeNova.getBar());
		assertEquals(String.format("Preço diferente do incluido - %s", fase), entidadeNova.getPreco(),
				entidade.getPreco());
		assertEquals(String.format("Cerveja diferente da incluida - %s", fase), entidadeNova.getCerveja(),
				entidade.getCerveja());
		assertEquals(String.format("Bar diferente do incluido - %s", fase), entidadeNova.getBar(), entidade.getBar());
		assertEquals(String.format("Preço medio da Cerveja diferente do informado na entidade - %s", fase), entidadeNova.getCerveja().getPrecoMedio(),
				entidade.getPreco());
		
		
		Cerveja cervejaRecuperada = (Cerveja)rest.find("Cerveja", entidadeNova.getCerveja().getId().toString());
		assertNotNull(String.format("Cerveja recuperada nula - %s", fase), cervejaRecuperada);
		assertNotNull(String.format("Preço medio da cerveja recuperada nulo - %s", fase), cervejaRecuperada.getPrecoMedio());
		assertEquals(String.format("Preço medio da Cerveja recuperada diferente do informado na entidade - %s", fase), cervejaRecuperada.getPrecoMedio(),
				entidade.getPreco());

	}

	@Override
	public void testarCamposAlteracao(BarCerveja entidadeAlterada, BarCerveja entidadeNova, BarCerveja entidade) {

	}

	
	@Override
	public void testeDeletarEntidade() {
		
		super.testeDeletarEntidade();
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
		if (cerveja != null) {
			
			Cerveja cervejaRecuperada = (Cerveja)rest.find("Cerveja", cerveja.getId().toString());
			assertNotNull(String.format("Cerveja recuperada nula - %s", fase), cervejaRecuperada);
			assertNull(String.format("Preço medio da cerveja recuperada não nulo - %s", fase), cervejaRecuperada.getPrecoMedio());
			
			rest.delete("Cerveja", cerveja.getId().toString());
			cerveja = null;
		}
		if (bar != null) {
			rest.delete("Bar", bar.getId().toString());
			bar = null;
		}
		
	}
	
	

}
