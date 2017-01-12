package br.com.rhiemer.beerpoints.modelo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.rhiemer.api.util.annotations.ToString;

@MappedSuperclass
public abstract class GenericEntityBeerPoints extends EntityBeerPoints {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6329286668684785571L;

	
	@NotBlank
	@Column(length = 250, nullable = false)
	@Length(min = 1, max = 250)
	@ToString
	@Audited
	private String nome;

	@Column(length = 1000)
	@Length(min = 1, max = 1000)
	@Audited
	private String texto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
