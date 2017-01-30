package br.com.rhiemer.beerpoints.modelo.entidades.embeddable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;

import br.com.rhiemer.beerpoints.modelo.entidades.Localizacao;

@Embeddable
public class EnderecoLocalizacao {
	
	
	@Embedded
	@Audited
	private Coordenadas coordenadas;
	
	@Embedded
	@Audited
	private Endereco enderco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "localizacao_id")
	private Localizacao localizacao;

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}

	public Endereco getEnderco() {
		return enderco;
	}

	public void setEnderco(Endereco enderco) {
		this.enderco = enderco;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

}
