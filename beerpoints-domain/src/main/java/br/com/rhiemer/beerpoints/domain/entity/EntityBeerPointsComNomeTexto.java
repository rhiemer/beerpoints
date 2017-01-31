package br.com.rhiemer.beerpoints.domain.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;

import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsComNomeTexto;

@MappedSuperclass
public abstract class EntityBeerPointsComNomeTexto extends EntityBeerPointsComNome
		implements IEntityBeerPointsComNomeTexto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8658827480259901073L;

	@Column(length = 1000)
	@Length(min = 1, max = 1000)
	@Audited
	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
