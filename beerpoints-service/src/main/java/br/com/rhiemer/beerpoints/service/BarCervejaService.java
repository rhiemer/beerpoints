package br.com.rhiemer.beerpoints.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

import br.com.rhiemer.api.jpa.annotations.ListenerEvent;
import br.com.rhiemer.api.jpa.builder.BuilderQuery;
import br.com.rhiemer.api.jpa.enums.EnumTipoQuery;
import br.com.rhiemer.api.jpa.listener.ListenerEnum;
import br.com.rhiemer.api.jpa.service.PersistenceServiceAplicacao;
import br.com.rhiemer.beerpoints.modelo.BarCerveja;
import br.com.rhiemer.beerpoints.modelo.Cerveja;

@Stateless
@LocalBean
public class BarCervejaService extends PersistenceServiceAplicacao<BarCerveja, Integer> {

	public BigDecimal buscarPrecoMedioCerveja(Integer cervejaId) {

		Map<Object, Object> parametros = new HashMap<>();
		parametros.put("cervejaId", cervejaId);
		BuilderQuery builderQuery = BuilderQuery.builder().resultClass(Double.class).sql("BarCerveja.precoMedioCerveja")
				.tipoQuery(EnumTipoQuery.namedQuery).parameters(parametros).build();
		Double precoMedio = excutarTypeQueryUniqueResult(builderQuery);
		return precoMedio == null ? null : BigDecimal.valueOf(precoMedio);
	}

	public void atualizarPrecoMedioCerveja(Cerveja cerveja) {
		BigDecimal precoMedio = buscarPrecoMedioCerveja(cerveja.getId());
		cerveja.setPrecoMedio(precoMedio);		
		getDao().atualizar(cerveja);
		getDao().flush();
		
	}

	public void onPostPersist(
			@Observes(during = TransactionPhase.BEFORE_COMPLETION) @ListenerEvent(ListenerEnum.PostPersist) BarCerveja barCerveja) {
		atualizarPrecoMedioCerveja(barCerveja.getCerveja());
	}

	public void onPostUpdate(
			@Observes(during = TransactionPhase.BEFORE_COMPLETION) @ListenerEvent(ListenerEnum.PostUpdate) BarCerveja barCerveja) {
		atualizarPrecoMedioCerveja(barCerveja.getCerveja());
	}

	public void onPostRemove(
			@Observes(during = TransactionPhase.BEFORE_COMPLETION) @ListenerEvent(ListenerEnum.PostRemove) BarCerveja barCerveja) {
		atualizarPrecoMedioCerveja(barCerveja.getCerveja());
	}

}
