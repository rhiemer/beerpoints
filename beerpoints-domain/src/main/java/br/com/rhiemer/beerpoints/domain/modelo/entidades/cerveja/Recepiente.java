package br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;

@Entity
@Table(name="TB_RECEPIENTE")
@RESTful(ConstantesBeerPointsDomain.RECEPIENTE)
@Audited
@AuditTable("TB_AUDITORIA_RECEPIENTE")
@SQLDelete(sql = "UPDATE TB_RECEPIENTE SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Recepiente extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

}
