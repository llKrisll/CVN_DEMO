package com.synapsis.cvn.web.dto;

public abstract class AbstractBasicDTO {
	
	
	 private String codigo;

	 private boolean activo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	 
	 
	 
}
