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
@Table(name = "TA_AMARGOR", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "controle_id" }, name = "UK_AMARGOR_CONTROLE_ID") })
@RESTful(ConstantesBeerPointsDomain.AMARGOR)
@Audited
@AuditTable("TB_AUDITORIA_AMARGOR")
@SQLDelete(sql = "UPDATE TA_AMARGOR SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@AssociationOverride(name = "controle_id", foreignKey = @ForeignKey(name = "FK_AMARGOR_CONTROLE_ENTIDADE"))
public class Amargor extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

}
