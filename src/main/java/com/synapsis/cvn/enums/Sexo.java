package com.synapsis.cvn.enums;

public enum Sexo {
	MASCULINO("enum.sexo.masculino","M"),FEMENINO("enum.sexo.femenino","F");
	
	private String descripcion;
	private String valor;
	
	private Sexo (String descripcion, String valor){
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
}
