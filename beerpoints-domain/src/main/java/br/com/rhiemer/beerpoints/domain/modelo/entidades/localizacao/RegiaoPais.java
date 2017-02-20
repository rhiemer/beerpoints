package br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsCadastroLocalizacao;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Pais;

@Entity
@Table(name = "TB_REGIAO_PAIS", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "controle_id" }, name = "UK_REGIAO_PAIS_CONTROLE_ID") })
@RESTful(ConstantesBeerPointsDomain.REGIAO_PAIS)
@Audited
@AuditTable("TB_AUDITORIA_REGIAO_PAIS")
@SQLDelete(sql = "UPDATE TB_REGIAO_PAIS SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@AssociationOverride(name = "controle_id", foreignKey = @ForeignKey(name = "FK_REGIAO_PAIS_CONTROLE_ENTIDADE"))
public class RegiaoPais extends EntityBeerPointsCoreModelo implements IEntityBeerPointsCadastroLocalizacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pais_id", nullable = false, foreignKey = @ForeignKey(name = "FK_REGIAO_PAIS_PAIS"))
	private Pais pais;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "localizacao_id", nullable = false, foreignKey = @ForeignKey(name = "FK_REGIAO_PAIS_LOCALIZACAO"))
	private Localizacao localizacao;

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

}
