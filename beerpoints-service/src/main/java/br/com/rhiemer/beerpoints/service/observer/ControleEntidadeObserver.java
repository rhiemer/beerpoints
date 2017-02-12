package br.com.rhiemer.beerpoints.service.observer;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;

import br.com.rhiemer.api.jpa.annotations.ListenerEvent;
import br.com.rhiemer.api.jpa.builder.BuilderQuery;
import br.com.rhiemer.api.jpa.enums.EnumTipoQuery;
import br.com.rhiemer.api.jpa.listener.ListenerEnum;
import br.com.rhiemer.api.util.annotations.interceptor.Trace;
import br.com.rhiemer.beerpoints.domain.enums.EnumEntidadeBeerPoints;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsComControle;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.controle.ControleEntidade;
import br.com.rhiemer.beerpoints.service.app.ControleEntidadeService;

@Trace
public class ControleEntidadeObserver {

	@Inject
	private ControleEntidadeService controleEntidadeService;

	public void onPrePersistControleEntidade(
			@Observes @ListenerEvent(ListenerEnum.PrePersist) IEntityBeerPointsComControle entityBeerPointsComControle) {
		ControleEntidade controleEntidade = new ControleEntidade();
		controleEntidade.relacionar(entityBeerPointsComControle);
	}

	public void onPostPersistControleEntidade(
			@Observes(during = TransactionPhase.BEFORE_COMPLETION) @ListenerEvent(ListenerEnum.PostPersist) IEntityBeerPointsComControle entityBeerPointsComControle) {
		ControleEntidade controleEntidade = entityBeerPointsComControle.getControleEntidade();
		controleEntidade.setEntidadeId((Integer) entityBeerPointsComControle.getPrimaryKey());
		controleEntidadeService.atualizar(controleEntidade);
		controleEntidadeService.flush();
	}

	public void onPreUpdateControleEntidade(
			@Observes @ListenerEvent(ListenerEnum.PreUpdate) IEntityBeerPointsComControle entityBeerPointsComControle) {
		ControleEntidade controleEntidade = controleEntidadeService.procurarPelaEntidade(entityBeerPointsComControle);
		controleEntidade.relacionar(entityBeerPointsComControle);
	}

	public void onPreRemoveControleEntidade(
			@Observes @ListenerEvent(ListenerEnum.PreRemove) IEntityBeerPointsComControle entityBeerPointsComControle) {
		ControleEntidade controleEntidade = controleEntidadeService.procurarPelaEntidade(entityBeerPointsComControle);
		controleEntidade.relacionar(entityBeerPointsComControle);
	}

	
}
