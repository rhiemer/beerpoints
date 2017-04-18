package br.com.rhiemer.beerpoints.domain.modelo.entidades.cervejaria;

import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.converter.EnumTipoCervejariaConverter;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.domain.enums.EnumTipoCervejaria;

@Entity
@Table(name = "TB_CERVEJARIA", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "controle_id" }, name = "UK_CERVEJARIA_CONTROLE_ID") })
@RESTful(ConstantesBeerPointsDomain.CERVEJARIA)
@Audited
@AuditTable("TB_AUDITORIA_CERVEJARIA")
@SQLDelete(sql = "UPDATE TB_CERVEJARIA SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@AssociationOverride(name = "controle_id", foreignKey = @ForeignKey(name = "FK_CERVEJARIA_CONTROLE_ENTIDADE"))
public class Cervejaria extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@NotNull
	@Convert(converter = EnumTipoCervejariaConverter.class)
	@Column(nullable = false, length = 20)
	private EnumTipoCervejaria tipoCervejaria;
	
	@OneToMany(mappedBy = "cervejaria",fetch = FetchType.LAZY)
	@JsonIgnore
	@XmlTransient
	private List<CervejariaLocalizacao> localizacoes;
	
	

	public Cervejaria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cervejaria(int chave, String nome) {
		super(chave, nome);
		// TODO Auto-generated constructor stub
	}

	public Cervejaria(int chave) {
		super(chave);
		// TODO Auto-generated constructor stub
	}

	public Cervejaria(Integer chave, String nome) {
		super(chave, nome);
		// TODO Auto-generated constructor stub
	}

	public Cervejaria(Integer chave) {
		super(chave);
		// TODO Auto-generated constructor stub
	}

	public EnumTipoCervejaria getTipoCervejaria() {
		return tipoCervejaria;
	}

	public void setTipoCervejaria(EnumTipoCervejaria tipoCervejaria) {
		this.tipoCervejaria = tipoCervejaria;
	}

	public List<CervejariaLocalizacao> getLocalizacoes() {
		return localizacoes;
	}

	public void setLocalizacoes(List<CervejariaLocalizacao> localizacoes) {
		this.localizacoes = localizacoes;
	}

}
