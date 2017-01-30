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
@Table(name="TB_FAMILIA")
@RESTful(ConstantesBeerPointsDomain.FAMILIA)
@Audited
@AuditTable("TB_AUDITORIA_FAMILIA")
@SQLDelete(sql = "UPDATE TB_FAMILIA SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Familia extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3272442859161662939L;

	

}
