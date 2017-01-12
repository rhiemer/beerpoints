package br.com.rhiemer.beerpoints.modelo;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.modelo.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.modelo.converter.EnumTipoFabricanteConverter;
import br.com.rhiemer.beerpoints.modelo.enums.EnumTipoFabricante;

@Entity
@Table(name="TB_FABRICANTE")
@RESTful(ConstantesBeerPointsDomain.FABRICANTE)
@Audited
@AuditTable("TB_AUDITORIA_FABRICANTE")
@SQLDelete(sql = "UPDATE TB_FABRICANTE SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Fabricante extends GenericEntityBeerPoints {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@NotNull
	@Convert(converter=EnumTipoFabricanteConverter.class)
	@Column(nullable = false, length = 20)
	private EnumTipoFabricante tipoFabricante;

	public EnumTipoFabricante getTipoFabricante() {
		return tipoFabricante;
	}

	public void setTipoFabricante(EnumTipoFabricante tipoFabricante) {
		this.tipoFabricante = tipoFabricante;
	}
}
