package br.com.rhiemer.beerpoints.modelo.entidades.interfaces;

import br.com.rhiemer.beerpoints.modelo.entidades.embeddable.EnderecoLocalizacao;

public interface IEntityBeerPointsComEnderecoLocalizacao extends IEntityBeerPoints {

	EnderecoLocalizacao getEnderecoLocalizacao();

	void setEnderecoLocalizacao(EnderecoLocalizacao enderecoLocalizacao);

}
