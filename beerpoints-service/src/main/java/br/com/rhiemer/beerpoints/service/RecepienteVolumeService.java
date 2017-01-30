package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.entidades.RecepienteVolume;

@Stateless
@LocalBean
public class RecepienteVolumeService extends PersitenceServiceBeerPointsEntidade<RecepienteVolume, Integer> {

}
