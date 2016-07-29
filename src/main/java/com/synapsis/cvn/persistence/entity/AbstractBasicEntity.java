package com.synapsis.cvn.persistence.entity;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AbstractBasicEntity {
	
    private String codigo;

    private boolean activo;
    
    @Column(name = "usuario_Creador", nullable = false)
    @CreatedBy
    private String usuarioCreador;
     
    @Column(name = "fecha_creacion", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
    @CreatedDate
    private ZonedDateTime fechaCreacion; 
  
    @Column(name = "usuario_Modificador", nullable = false)
    @LastModifiedBy
    private String usuarioModificador;
     
    @Column(name = "fecha_modificacion")
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
    @LastModifiedDate
    private ZonedDateTime fechaModificacion;
    

    public AbstractBasicEntity() {
    	
	}
    
	public abstract Long getId();

	public abstract void setId(Long id);
    
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

	public String getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(String usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

	public ZonedDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(ZonedDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	public ZonedDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(ZonedDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
    
}
