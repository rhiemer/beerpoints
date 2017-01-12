package br.com.rhiemer.beerpoints.modelo.enums;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import br.com.rhiemer.api.jpa.enums.EnumeracaoComNome;

public enum EnumTipoFabricante implements EnumeracaoComNome {

	PEQUENO("Pequeno"), GRANDE("Grande");

	private static Map<String, EnumTipoFabricante> mapNome;

	static {
		mapNome=new HashMap<>();
		for (EnumTipoFabricante value : EnumTipoFabricante.values()) {
			mapNome.put(value.getNome(), value);
		}
	}

	private String nome;

	private EnumTipoFabricante(String nome) {
		this.nome = nome;
	}

	@JsonValue
	public String getNome() {
		return nome;
	}
	
	@JsonCreator
	public static EnumTipoFabricante getByNome(String nome)
	{
		return mapNome.get(nome);
	}

}
