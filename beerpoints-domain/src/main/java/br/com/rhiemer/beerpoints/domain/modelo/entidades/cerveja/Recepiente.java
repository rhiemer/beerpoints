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

import br.com.rhiemer.api.util.annotations.rest.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;

@Entity
@Table(name = "TA_RECEPIENTE", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "controle_id" }, name = "UK_RECEPIENTE_CONTROLE_ID") })
@RESTful(ConstantesBeerPointsDomain.RECEPIENTE)
@Audited
@AuditTable("TB_AUDITORIA_RECEPIENTE")
@SQLDelete(sql = "UPDATE TA_RECEPIENTE SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@AssociationOverride(name = "controle_id", foreignKey = @ForeignKey(name = "FK_RECEPIENTE_CONTROLE_ENTIDADE"))
public class Recepiente extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

}
