package br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.rhiemer.api.jpa.entity.GenericEntityComIdIncrementalDeleteLogico;
import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.api.util.annotations.ToString;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsAuxiliar;

@Entity
@Table(name = "TB_TIPO_LOCALIZACAO")
@RESTful(ConstantesBeerPointsDomain.TIPO_LOCALIZACAO)
@Audited
@AuditTable("TB_AUDITORIA_TIPO_LOCALIZACAO")
@SQLDelete(sql = "UPDATE TB_TIPO_LOCALIZACAO SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class TipoLocalizacao extends GenericEntityComIdIncrementalDeleteLogico implements IEntityBeerPointsAuxiliar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@NotBlank
	@Column(length = 250, nullable = false)
	@Length(min = 1, max = 250)
	@ToString
	@Audited
	private String nome;
	
	@Column(length = 250)
	@Length(min = 1, max = 250)
	@ToString
	@Audited
	private String classe;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

}
