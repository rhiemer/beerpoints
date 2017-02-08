package br.com.rhiemer.beerpoints.domain.converter;

import javax.persistence.AttributeConverter;

import br.com.rhiemer.beerpoints.domain.enums.EnumEntidadeBeerPoints;

public class EnumEntidadeBeerPointsConverter implements AttributeConverter<EnumEntidadeBeerPoints, String> {

	@Override
	public String convertToDatabaseColumn(EnumEntidadeBeerPoints attribute) {

		return attribute == null ? null : attribute.getNome();
	}

	@Override
	public EnumEntidadeBeerPoints convertToEntityAttribute(String dbData) {
		return EnumEntidadeBeerPoints.getByNome(dbData);
	}

}
