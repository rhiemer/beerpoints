package br.com.rhiemer.beerpoints.modelo.entidades.embeddable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Embeddable
public class CoordenadasRegiao {
	
	@Column(precision = 20, scale = 8)
	@DecimalMax("999")
	@DecimalMin("0.00000001")
	private BigDecimal latitude;
	
	@Column(precision = 20, scale = 8)
	@DecimalMax("1000")
	@DecimalMin("0.00000001")
	private BigDecimal longitude;

	@Column(precision = 20, scale = 8)
	@DecimalMax("999")
	@DecimalMin("0.00000001")
	private BigDecimal latitudeDelta;
	
	@Column(precision = 20, scale = 8)
	@DecimalMax("1000")
	@DecimalMin("0.00000001")
	private BigDecimal longitudeDelta;

	
	public BigDecimal getLatitudeDelta() {
		return latitudeDelta;
	}

	public void setLatitudeDelta(BigDecimal latitudeDelta) {
		this.latitudeDelta = latitudeDelta;
	}

	public BigDecimal getLongitudeDelta() {
		return longitudeDelta;
	}

	public void setLongitudeDelta(BigDecimal longitudeDelta) {
		this.longitudeDelta = longitudeDelta;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

}
