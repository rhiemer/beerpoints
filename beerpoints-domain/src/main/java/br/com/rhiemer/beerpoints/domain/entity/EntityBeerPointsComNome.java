package br.com.rhiemer.beerpoints.domain.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.rhiemer.api.util.annotations.entity.ToString;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsComNome;

@MappedSuperclass
public abstract class EntityBeerPointsComNome extends EntityBeerPointsCoreComIdIncrementalDeleteLogico implements IEntityBeerPointsComNome {

	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1426879399390543682L;
	
	@NotBlank
	@Column(length = 250, nullable = false)
	@Length(min = 1, max = 250)
	@ToString
	@Audited
	private String nome;	

	/* (non-Javadoc)
	 * @see br.com.rhiemer.beerpoints.modelo.IEntityBeerPointsComNome#getNome()
	 */
	@Override
	public String getNome() {
		return nome;
	}

	/* (non-Javadoc)
	 * @see br.com.rhiemer.beerpoints.modelo.IEntityBeerPointsComNome#setNome(java.lang.String)
	 */
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
