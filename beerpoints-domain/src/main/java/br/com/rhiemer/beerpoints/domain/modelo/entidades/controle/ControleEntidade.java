package br.com.rhiemer.beerpoints.domain.modelo.entidades.controle;

import java.util.Optional;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.jpa.annotations.UniqueKey;
import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.api.util.helper.Helper;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.converter.EnumEntidadeBeerPointsConverter;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsComNomeTexto;
import br.com.rhiemer.beerpoints.domain.enums.EnumEntidadeBeerPoints;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsComControle;

@Entity
@Table(name = "TB_CONTROLE_ENTIDADE", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "entidade", "entidadeId" }) })
@RESTful(ConstantesBeerPointsDomain.CONTROLE_ENTIDADE)
@Audited
@AuditTable("TB_AUDITORIA_CONTROLE_ENTIDADE")
@SQLDelete(sql = "UPDATE TB_CONTROLE_ENTIDADE SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@AttributeOverride(name = "nome", column = @Column(length = 250, nullable = true))
@UniqueKey(nome="controleEntidade",columnNames = { "entidade", "entidadeId" }, validar = true)
@NamedQuery(name = "ControleEntidade.procurarPelaEntidade", query = "select a from ControleEntidade a where a.entidade =:entidade and a.entidadeId =:entidadeId ")
public class ControleEntidade extends EntityBeerPointsComNomeTexto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;
	protected static final String[] camposAtualizacao = new String[] { "nome", "texto" };
	
	
	

	@Transient
	protected IEntityBeerPointsComControle entityBeerPointsComControle;

	@NotNull
	@Column(name = "entidade", nullable = false, updatable = false)
	@Convert(converter = EnumEntidadeBeerPointsConverter.class)
	private EnumEntidadeBeerPoints entidade;

	@Column
	private Integer entidadeId;

	public ControleEntidade() {
		super();
	}

	public ControleEntidade(Integer id) {
		super();
		this.setId(id);
	}

	public EnumEntidadeBeerPoints getEntidade() {
		return entidade;
	}

	public void setEntidade(EnumEntidadeBeerPoints entidade) {
		this.entidade = entidade;
	}

	public Integer getEntidadeId() {
		return entidadeId;
	}

	public void setEntidadeId(Integer entidadeId) {
		this.entidadeId = entidadeId;
	}

	public String nomePadraoEntidade() {
		return Optional.ofNullable(entidade).map(t -> String.format("%s: Id=%s", t.getNome(), entidadeId)).get();
	}

	@Override
	protected void prePersist() {
		super.prePersist();
		Optional.ofNullable(this.entityBeerPointsComControle).ifPresent(t -> criarEntidade());
	}
	
	@Override
	protected void preUpdate() {
		super.preUpdate();
		Optional.ofNullable(this.entityBeerPointsComControle).ifPresent(t -> criarEntidade());
	}

	public void relacionar(IEntityBeerPointsComControle entityBeerPointsComControle) {
		this.entityBeerPointsComControle = entityBeerPointsComControle;
		entityBeerPointsComControle.setControleEntidade(this);
	}

	protected void criarEntidade() {
		this.setEntidade(EnumEntidadeBeerPoints.getByClasse(entityBeerPointsComControle.getClass()));
		setFieldsEntidade();
	}

	public void setFieldsEntidade() {

		for (String campo : camposAtualizacao) {
			Helper.setValueMethodOrField(this, campo,
					Helper.getValueMethodOrField(this.entityBeerPointsComControle, campo));
		}

		this.setNome(Optional.ofNullable(this.getNome()).orElse(nomePadraoEntidade()));
	}

}
