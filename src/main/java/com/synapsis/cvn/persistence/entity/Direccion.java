package com.synapsis.cvn.persistence.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Direccion {
	
	private String descripcion;
	
	private String referencia;
	
	private String pais;
	
	private String provincia;
	
	private String ciudad;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Direccion [getDescripcion()=" + getDescripcion()
				+ ", getReferencia()=" + getReferencia() + ", getPais()="
				+ getPais() + ", getProvincia()=" + getProvincia()
				+ ", getCiudad()=" + getCiudad() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
