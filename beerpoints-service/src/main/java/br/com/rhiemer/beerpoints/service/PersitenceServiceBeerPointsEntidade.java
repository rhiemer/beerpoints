package br.com.rhiemer.beerpoints.service;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

import br.com.rhiemer.api.jpa.annotations.ListenerEvent;
import br.com.rhiemer.api.jpa.listener.ListenerEnum;
import br.com.rhiemer.api.jpa.service.PersistenceServiceAplicacao;
import br.com.rhiemer.api.util.helper.Helper;
import br.com.rhiemer.beerpoints.modelo.entidades.ControleEntidade;
import br.com.rhiemer.beerpoints.modelo.entidades.interfaces.IEntityBeerPoints;
import br.com.rhiemer.beerpoints.modelo.entidades.interfaces.IEntityBeerPointsComControle;
import br.com.rhiemer.beerpoints.modelo.enums.EnumEntidadeBeerPoints;

public abstract class PersitenceServiceBeerPointsEntidade<T extends IEntityBeerPoints, K extends Serializable>
		extends PersistenceServiceAplicacao<T, K> {

	protected void setCamposControleEntidade(ControleEntidade controleEntidade,
			IEntityBeerPointsComControle entityBeerPointsComControle) {
		for (Field f : ControleEntidade.class.getSuperclass().getDeclaredFields()) {
			Helper.setValueMethodOrField(controleEntidade, f.getName(),
					Helper.getValueMethodOrField(entityBeerPointsComControle, f.getName()));
		}
	}

	protected ControleEntidade criarEntidade(IEntityBeerPointsComControle entityBeerPointsComControle) {
		ControleEntidade controleEntidade = new ControleEntidade();
		controleEntidade.setEntidadeId((Integer) entityBeerPointsComControle.getPrimaryKey());
		controleEntidade.setEntidade(EnumEntidadeBeerPoints.criarEntidade(entityBeerPointsComControle.getClass()));
		return controleEntidade;
	}

	public void onPrePersistControleEntidade(
			@Observes(during = TransactionPhase.BEFORE_COMPLETION) @ListenerEvent(ListenerEnum.PrePersist) IEntityBeerPointsComControle entityBeerPointsComControle) {
		ControleEntidade controleEntidade = criarEntidade(entityBeerPointsComControle);
		setCamposControleEntidade(controleEntidade, entityBeerPointsComControle);
		getDao().adicionar(controleEntidade);
		entityBeerPointsComControle.setControleId(controleEntidade.getId());
	}

	public void onPreUpdateControleEntidade(
			@Observes(during = TransactionPhase.BEFORE_COMPLETION) @ListenerEvent(ListenerEnum.PreUpdate) IEntityBeerPointsComControle entityBeerPointsComControle) {
		ControleEntidade controleEntidade = criarEntidade(entityBeerPointsComControle);
		setCamposControleEntidade(controleEntidade, entityBeerPointsComControle);
		controleEntidade.setId(entityBeerPointsComControle.getControleId());
		getDao().atualizar(controleEntidade);

	}

	public void onPreRemoveControleEntidade(
			@Observes(during = TransactionPhase.BEFORE_COMPLETION) @ListenerEvent(ListenerEnum.PreRemove) IEntityBeerPointsComControle entityBeerPointsComControle) {
		ControleEntidade controleEntidade = criarEntidade(entityBeerPointsComControle);
		controleEntidade.setId(entityBeerPointsComControle.getControleId());
		getDao().removerPeloId(entityBeerPointsComControle.getControleId(), ControleEntidade.class);
	}

}
