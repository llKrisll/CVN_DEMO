package com.synapsis.cvn.web.dto;

import com.synapsis.cvn.persistence.entity.TipoDocumentoIdentidad;

public class TipoDocumentoDTO extends TipoDocumentoIdentidad {
	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
