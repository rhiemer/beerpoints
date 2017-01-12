package br.com.rhiemer.beerpoints.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.modelo.constantes.ConstantesBeerPointsDomain;

@Entity
@Table(name="TB_PAIS")
@RESTful(ConstantesBeerPointsDomain.PAIS)
@Audited
@AuditTable("TB_AUDITORIA_PAIS")
@SQLDelete(sql = "UPDATE TB_PAIS SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Pais extends GenericEntityBeerPoints {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

}
