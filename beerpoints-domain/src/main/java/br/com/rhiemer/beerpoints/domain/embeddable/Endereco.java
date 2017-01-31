package br.com.rhiemer.beerpoints.domain.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.Municipio;

@Embeddable
public class Endereco {
	
	@NotBlank
	@Column(length = 250)
	@Length(min = 1, max = 250)
	@Audited
	private String logradouro;
	
	@NotBlank
	@Column(length = 60)
	@Length(min = 1, max = 60)
	@Audited
	private String numero;
	
	@Column(length = 60)
	@Length(min = 1, max = 60)
	@Audited
	private String complemento;
	
	@NotBlank
	@Column(length = 60)
	@Length(min = 1, max = 60)
	@Audited
	private String cep;
	
	@Column(length = 1000)
	@Length(min = 1, max = 1000)
	@Audited
	private String observacaoEndereco;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "municipio_id", nullable = false)
	private Municipio municipio;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getObservacaoEndereco() {
		return observacaoEndereco;
	}

	public void setObservacaoEndereco(String observacaoEndereco) {
		this.observacaoEndereco = observacaoEndereco;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	

}
