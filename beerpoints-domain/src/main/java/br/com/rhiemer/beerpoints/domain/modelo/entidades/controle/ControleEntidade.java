package br.com.rhiemer.beerpoints.domain.modelo.entidades.controle;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.jpa.annotations.UniqueKey;
import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsComNomeTexto;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.auxiliares.Entidade;

@Entity
@Table(name="TB_CONTROLE_ENTIDADE", uniqueConstraints = { @UniqueConstraint(columnNames = { "entidade", "entidadeId" }) })
@RESTful(ConstantesBeerPointsDomain.CONTROLE_ENTIDADE)
@Audited
@AuditTable("TB_AUDITORIA_CONTROLE_ENTIDADE")
@SQLDelete(sql = "UPDATE TB_CONTROLE_ENTIDADE SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@AttributeOverride(name="nome",column = @Column(length = 250, nullable = true))
@UniqueKey(columnNames={"entidade","entidadeId"},validar=true)
public class ControleEntidade extends EntityBeerPointsComNomeTexto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;
	
	
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entidade", nullable = false,updatable=false)
	private Entidade entidade;
	
	@NotNull
	@Column(nullable = false,updatable=false)
	private Integer entidadeId;

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}
	
	public Integer getEntidadeId() {
		return entidadeId;
	}

	public void setEntidadeId(Integer entidadeId) {
		this.entidadeId = entidadeId;
	}

	

	protected void prePersist()
	{
		if (this.getNome()==null)
		 this.setNome(String.format("%s: Id=%s",entidade.getId(),entidadeId));	
	}
	

}
