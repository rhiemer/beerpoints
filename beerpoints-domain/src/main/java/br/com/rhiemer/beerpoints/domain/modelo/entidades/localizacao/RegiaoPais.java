package br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Pais;

@Entity
@Table(name = "TB_REGIAO_PAIS")
@RESTful(ConstantesBeerPointsDomain.REGIAO_PAIS)
@Audited
@AuditTable("TB_AUDITORIA_REGIAO_PAIS")
@SQLDelete(sql = "UPDATE TB_REGIAO_PAIS SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class RegiaoPais extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pais_id", nullable = false)
	private Pais pais;

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
