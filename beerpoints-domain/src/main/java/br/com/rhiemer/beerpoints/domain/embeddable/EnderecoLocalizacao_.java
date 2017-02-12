package br.com.rhiemer.beerpoints.domain.embeddable;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.Localizacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EnderecoLocalizacao.class)
public abstract class EnderecoLocalizacao_ {

	public static volatile SingularAttribute<EnderecoLocalizacao, Localizacao> localizacao;
	public static volatile SingularAttribute<EnderecoLocalizacao, Coordenadas> coordenadas;
	public static volatile SingularAttribute<EnderecoLocalizacao, Endereco> enderco;

}

