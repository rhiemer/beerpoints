package br.com.rhiemer.beerpoints.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.modelo.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.modelo.entidades.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.modelo.entidades.interfaces.IEntityBeerPointsCadastroLocalizacao;
import br.com.rhiemer.beerpoints.modelo.entidades.interfaces.IEntityBeerPointsIBGE;

@Entity
@Table(name="TB_MUNICIPIO")
@RESTful(ConstantesBeerPointsDomain.MUNICIPIO)
@Audited
@AuditTable("TB_AUDITORIA_MUNICIPIO")
@SQLDelete(sql = "UPDATE TB_MUNICIPIO SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Municipio extends EntityBeerPointsCoreModelo implements IEntityBeerPointsIBGE,IEntityBeerPointsCadastroLocalizacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;
	
	@NotNull
	@Column(nullable = false)
	private Integer codigoIBGE;
	
	@NotNull
	@Column(nullable = false)
	private Localizacao localizacao;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uf_id", nullable = false)
	private UF uf;
	
	public Integer getCodigoIBGE() {
		return codigoIBGE;
	}
	public void setCodigoIBGE(Integer codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}
	
	public Localizacao getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
	public UF getUf() {
		return uf;
	}
	public void setUf(UF uf) {
		this.uf = uf;
	}
	

	

	

}
