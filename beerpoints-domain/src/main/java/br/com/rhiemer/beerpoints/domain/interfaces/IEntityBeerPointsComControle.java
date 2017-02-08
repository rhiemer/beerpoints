package br.com.rhiemer.beerpoints.domain.interfaces;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.controle.ControleEntidade;

public interface IEntityBeerPointsComControle extends IEntityBeerPoints{
	
	Integer getControleId();
	
	void setControleId(Integer controleId);
	
	ControleEntidade getControleEntidade();
	
	void setControleEntidade(ControleEntidade controleEntidade);
	
	Object getPrimaryKey();

}
