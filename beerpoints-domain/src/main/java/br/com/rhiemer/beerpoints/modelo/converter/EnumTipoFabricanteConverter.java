package br.com.rhiemer.beerpoints.modelo.converter;

import javax.persistence.AttributeConverter;

import br.com.rhiemer.beerpoints.modelo.enums.EnumTipoFabricante;

public class EnumTipoFabricanteConverter implements AttributeConverter<EnumTipoFabricante, String> {

	@Override
	public String convertToDatabaseColumn(EnumTipoFabricante attribute) {
		return attribute == null?null:attribute.getNome();
	}

	@Override
	public EnumTipoFabricante convertToEntityAttribute(String dbData) {
		return EnumTipoFabricante.getByNome(dbData);
	}
	
	

}
