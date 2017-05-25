package br.com.rhiemer.beerpoints.domain.modelo.entidades.comida;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.util.annotations.rest.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;

@Entity
@Table(name = "TB_COMIDA", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "controle_id" }, name = "UK_COMIDA_CONTROLE_ID") })
@RESTful(ConstantesBeerPointsDomain.COMIDA)
@Audited
@AuditTable("TB_AUDITORIA_COMIDA")
@SQLDelete(sql = "UPDATE TB_COMIDA SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@AssociationOverride(name = "controle_id", foreignKey = @ForeignKey(name = "FK_COMIDA_CONTROLE_ENTIDADE"))
public class Comida extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5476226543382291377L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comida_pai_id", nullable = false, foreignKey = @ForeignKey(name = "FK_COMIDA_PAI"))
	private Comida comidaPai;

	public Comida getComidaPai() {
		return comidaPai;
	}

	public void setComidaPai(Comida comidaPai) {
		this.comidaPai = comidaPai;
	}

}
