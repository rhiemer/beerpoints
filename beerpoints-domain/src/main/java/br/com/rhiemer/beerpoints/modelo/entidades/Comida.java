package br.com.rhiemer.beerpoints.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.modelo.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.modelo.entidades.entity.EntityBeerPointsCoreModelo;

@Entity
@Table(name="TB_COMIDA")
@RESTful(ConstantesBeerPointsDomain.COMIDA)
@Audited
@AuditTable("TB_AUDITORIA_COMIDA")
@SQLDelete(sql = "UPDATE TB_COMIDA SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Comida extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5476226543382291377L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comida_pai_id", nullable = false)
	private Comida comidaPai;

	public Comida getComidaPai() {
		return comidaPai;
	}

	public void setComidaPai(Comida comidaPai) {
		this.comidaPai = comidaPai;
	}

	

	

}
