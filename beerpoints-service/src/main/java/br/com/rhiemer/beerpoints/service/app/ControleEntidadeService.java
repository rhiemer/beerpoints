package br.com.rhiemer.beerpoints.service.app;

import static br.com.rhiemer.beerpoints.domain.modelo.entidades.controle.ControleEntidade.CONTROLE_ENTIDADE_UNIQUE_KEY;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.enums.EnumEntidadeBeerPoints;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsComControle;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.controle.ControleEntidade;
import br.com.rhiemer.beerpoints.service.entity.PersitenceServiceBeerPointsEntidadeComNome;

@Stateless
@LocalBean
public class ControleEntidadeService extends PersitenceServiceBeerPointsEntidadeComNome<ControleEntidade, String> {

	public ControleEntidade procurarPelaEntidade(final IEntityBeerPointsComControle entityBeerPointsComControle) {
		ControleEntidade result = (ControleEntidade) procurarPorUniqueKeyByNome(CONTROLE_ENTIDADE_UNIQUE_KEY,
				EnumEntidadeBeerPoints.getByClasse(entityBeerPointsComControle.getClass()),
				entityBeerPointsComControle.getPrimaryKey());
		return result;

	}

}
