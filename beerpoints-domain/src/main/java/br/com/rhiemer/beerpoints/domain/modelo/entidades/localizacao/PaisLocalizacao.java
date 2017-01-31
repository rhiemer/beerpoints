package br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsCadastroLocalizacao;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsIBGE;

@Entity
@Table(name="TB_PAIS_LOCALIZACAO")
@RESTful(ConstantesBeerPointsDomain.PAIS_LOCALIZACAO)
@Audited
@AuditTable("TB_AUDITORIA_PAIS_LOCALIZACAO")
@SQLDelete(sql = "UPDATE TB_PAIS_LOCALIZACAO SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class PaisLocalizacao extends EntityBeerPointsCoreModelo implements IEntityBeerPointsIBGE,IEntityBeerPointsCadastroLocalizacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;
	
	@NotNull
	@Column(nullable = false)
	private Integer codigoIBGE;
	
	@NotNull
	@Column(nullable = false)
	private String  sigla;
	
	@NotNull
	@Column(nullable = false)
	private Localizacao localizacao;
	
	public Integer getCodigoIBGE() {
		return codigoIBGE;
	}
	public void setCodigoIBGE(Integer codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Localizacao getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	

	

}
