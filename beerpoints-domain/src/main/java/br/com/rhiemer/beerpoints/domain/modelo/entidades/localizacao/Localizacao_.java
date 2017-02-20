package br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao;

import br.com.rhiemer.beerpoints.domain.embeddable.CoordenadasRegiao;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Localizacao.class)
public abstract class Localizacao_ extends br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo_ {

	public static volatile SingularAttribute<Localizacao, TipoLocalizacao> tipo;
	public static volatile SetAttribute<Localizacao, Localizacao> localizacaoFilhas;
	public static volatile SetAttribute<Localizacao, Localizacao> localizacaoPais;
	public static volatile SingularAttribute<Localizacao, CoordenadasRegiao> coordenadasRegiao;

}

