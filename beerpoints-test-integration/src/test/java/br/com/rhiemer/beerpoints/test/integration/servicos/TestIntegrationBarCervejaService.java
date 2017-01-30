package br.com.rhiemer.beerpoints.test.integration.servicos;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;

import br.com.rhiemer.beerpoints.modelo.entidades.Bar;
import br.com.rhiemer.beerpoints.modelo.entidades.BarCerveja;
import br.com.rhiemer.beerpoints.modelo.entidades.Cerveja;
import br.com.rhiemer.beerpoints.modelo.entidades.Cervejaria;
import br.com.rhiemer.beerpoints.modelo.entidades.Estilo;
import br.com.rhiemer.beerpoints.modelo.entidades.Pais;
import br.com.rhiemer.beerpoints.modelo.entidades.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.modelo.enums.EnumTipoCervejaria;
import br.com.rhiemer.beerpoints.test.integration.util.BeerPointstWSUtilsArquillian;

public class TestIntegrationBarCervejaService extends TestEntidadeBeerPoints<BarCerveja> {

	private Pais pais;
	private Estilo estilo;
	private Cervejaria cervejaria;
	private Cerveja cerveja;
	private Bar bar;

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

		Cervejaria cervejaria = criarGenericEntityBeerPoints(Cervejaria.class);
		cervejaria.setTipoCervejaria(EnumTipoCervejaria.GRANDE);
		this.cervejaria = (Cervejaria) rest.add("Cervejaria", cervejaria);

		Cerveja cerveja = criarGenericEntityBeerPoints(Cerveja.class);
		cerveja.setPais(this.pais);
		cerveja.setEstilo(this.estilo);
		cerveja.setCervejaria(this.cervejaria);
		this.cerveja = (Cerveja) rest.add("Cerveja", cerveja);

		Bar bar = criarGenericEntityBeerPoints(Bar.class);		
		this.bar = (Bar) rest.add("Bar", bar);

	}

	public <K extends EntityBeerPointsCoreModelo> K criarGenericEntityBeerPoints(Class<K> classe) {
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
	public void carregarCampos(BarCerveja entidade) {
		entidade.setBar(this.bar);
		entidade.setCerveja(this.cerveja);
		
	}

	@Override
	public void testarCamposBasicos(BarCerveja entidadeNova, BarCerveja entidade) {
		super.testarCamposBasicos(entidadeNova, entidade);
		assertNotNull(String.format("Cerveja nula - %s", fase), entidadeNova.getCerveja());
		assertNotNull(String.format("Bar nulo - %s", fase), entidadeNova.getBar());
		assertEquals(String.format("Cerveja diferente da incluida - %s", fase), entidadeNova.getCerveja(),
				entidade.getCerveja());
		assertEquals(String.format("Bar diferente do incluido - %s", fase), entidadeNova.getBar(), entidade.getBar());
		
		Cerveja cervejaRecuperada = (Cerveja)rest.find("Cerveja", entidadeNova.getCerveja().getId().toString());
		assertNotNull(String.format("Cerveja recuperada nula - %s", fase), cervejaRecuperada);		

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
		if (cervejaria != null) {
			rest.delete("Cervejaria", cervejaria.getId().toString());
			cervejaria = null;
		}
		if (cerveja != null) {
			rest.delete("Cerveja", cerveja.getId().toString());
			cerveja = null;
		}
		if (bar != null) {
			rest.delete("Bar", bar.getId().toString());
			bar = null;
		}
		
	}
	
	

}
