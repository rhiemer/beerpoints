package br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;

@Entity
@Table(name="TB_FAMILIA", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "controle_id" }, name = "UK_FAMILIA_CONTROLE_ID") })
@RESTful(ConstantesBeerPointsDomain.FAMILIA)
@Audited
@AuditTable("TB_AUDITORIA_FAMILIA")
@SQLDelete(sql = "UPDATE TB_FAMILIA SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@AssociationOverride(name = "controle_id", foreignKey = @ForeignKey(name = "FK_FAMILIA_CONTROLE_ENTIDADE"))
public class Familia extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3272442859161662939L;

	

}
