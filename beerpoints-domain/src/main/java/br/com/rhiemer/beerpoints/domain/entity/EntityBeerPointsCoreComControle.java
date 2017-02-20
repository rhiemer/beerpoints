package br.com.rhiemer.beerpoints.domain.entity;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsComControle;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.controle.ControleEntidade;

@MappedSuperclass
public abstract class EntityBeerPointsCoreComControle extends EntityBeerPointsCoreComIdIncrementalDeleteLogico
		implements IEntityBeerPointsComControle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073080721361887314L;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "controle_id", referencedColumnName = "id", nullable = false, updatable = false)
	@JsonIgnore
	@Audited
	private ControleEntidade controleEntidade;

	@Column(name = "controle_id", updatable = false, insertable = false)
	private Integer controleId;

	public Integer getControleId() {
		// erro ao converter o JSON no retorno dos serviços
		try {
			return Optional.ofNullable(this.controleEntidade).map(t -> t.getId()).orElse(this.controleId);

		} catch (Exception e) {
			return this.controleId;
		}
	}

	public void setControleId(Integer controleId) {
		this.controleId = controleId;
	}

	@Override
	public ControleEntidade getControleEntidade() {
		return controleEntidade;
	}

	@Override
	public void setControleEntidade(ControleEntidade controleEntidade) {
		this.controleEntidade = controleEntidade;
	}

}
