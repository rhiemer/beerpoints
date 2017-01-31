package br.com.rhiemer.beerpoints.domain.modelo.entidades.auxiliares;

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
@Table(name="TB_TAG")
@RESTful(ConstantesBeerPointsDomain.TAG)
@Audited
@AuditTable("TB_AUDITORIA_TAG")
@SQLDelete(sql = "UPDATE TB_TAG SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Tag extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3254707490899593234L;

	

}
