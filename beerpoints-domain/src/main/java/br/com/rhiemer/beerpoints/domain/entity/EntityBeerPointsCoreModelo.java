package br.com.rhiemer.beerpoints.domain.entity;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsComControle;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.controle.ControleEntidade;

@MappedSuperclass
public abstract class EntityBeerPointsCoreModelo extends EntityBeerPointsComNomeTexto
		implements IEntityBeerPointsCoreModelo, IEntityBeerPointsComControle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6329286668684785571L;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "controleId", referencedColumnName = "id", unique = true, nullable = false, updatable = false)
	@JsonIgnore
	private ControleEntidade controleEntidade;

	@Column(name = "controleId", nullable = false, unique = true, updatable = false, insertable = false)
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
