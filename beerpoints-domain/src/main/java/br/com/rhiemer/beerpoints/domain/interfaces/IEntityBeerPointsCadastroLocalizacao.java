package br.com.rhiemer.beerpoints.domain.interfaces;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.Localizacao;

public interface IEntityBeerPointsCadastroLocalizacao extends IEntityBeerPoints{
	
	Localizacao getLocalizacao();
	
	void setLocalizacao(Localizacao localizacao);
	
	

}
