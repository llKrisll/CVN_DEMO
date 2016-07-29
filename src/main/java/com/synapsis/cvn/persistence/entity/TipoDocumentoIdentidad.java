package com.synapsis.cvn.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoDocumentoIdentidad extends AbstractBasicEntity {

	@GeneratedValue
    @Id
//    @Column(name="ID_TIPO_DOCUM_IDENT")
    private Long id;
	
	private String descripcion;
	
	public TipoDocumentoIdentidad() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoDocumentoIdentidad [getId()=" + getId()
				+ ", getDescripcion()=" + getDescripcion() + ", getCodigo()="
				+ getCodigo() + ", isActivo()="
				+ isActivo() + "]";
	}
	
}
