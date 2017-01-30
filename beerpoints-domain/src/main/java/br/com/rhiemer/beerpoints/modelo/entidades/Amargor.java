package br.com.rhiemer.beerpoints.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.modelo.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.modelo.entidades.entity.EntityBeerPointsCoreModelo;

@Entity
@Table(name="TB_AMARGOR")
@RESTful(ConstantesBeerPointsDomain.AMARGOR)
@Audited
@AuditTable("TB_AUDITORIA_AMRAGOR")
@SQLDelete(sql = "UPDATE TB_AMRAGOR SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Amargor extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

}
