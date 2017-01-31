package br.com.rhiemer.beerpoints.domain.interfaces;

import br.com.rhiemer.beerpoints.domain.embeddable.EnderecoLocalizacao;

public interface IEntityBeerPointsComEnderecoLocalizacao extends IEntityBeerPoints {

	EnderecoLocalizacao getEnderecoLocalizacao();

	void setEnderecoLocalizacao(EnderecoLocalizacao enderecoLocalizacao);

}
