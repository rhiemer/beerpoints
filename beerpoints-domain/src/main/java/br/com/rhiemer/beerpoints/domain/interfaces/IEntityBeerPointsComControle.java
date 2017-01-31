package br.com.rhiemer.beerpoints.domain.interfaces;

public interface IEntityBeerPointsComControle extends IEntityBeerPoints{
	
	Integer getControleId();
	
	void setControleId(Integer controleId);
	
	Object getPrimaryKey();

}
