package com.synapsis.cvn.persistence.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Persona extends AbstractBasicEntity{
	
	@GeneratedValue
    @Id
//    @Column(name="ID_PERSONA")
    private Long id;

    private String nombres;

    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private String sexo;
    
    @ManyToOne
    private TipoDocumentoIdentidad tipoDocumentoIdentidad;
    
    private String numeroDocumentoIdentidad;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    
    @Embedded
    private Direccion direccion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<CaracteristicasFisicas> caracteristicasFisicas;
    
    private String email;
    
   
	public Persona() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CaracteristicasFisicas> getCaracteristicasFisicas() {
		if (this.caracteristicasFisicas==null) {
			this.caracteristicasFisicas=new ArrayList<CaracteristicasFisicas>();
		}
		return caracteristicasFisicas;
	}

	public void setCaracteristicasFisicas(
			List<CaracteristicasFisicas> caracteristicasFisicas) {
		this.caracteristicasFisicas.clear();
	    this.caracteristicasFisicas.addAll(caracteristicasFisicas);
	}



	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public TipoDocumentoIdentidad getTipoDocumentoIdentidad() {
		return tipoDocumentoIdentidad;
	}

	public void setTipoDocumentoIdentidad(
			TipoDocumentoIdentidad tipoDocumentoIdentidad) {
		this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
	}

	public String getNumeroDocumentoIdentidad() {
		return numeroDocumentoIdentidad;
	}

	public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
		this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persona [getId()=" + getId() + ", getNombres()=" + getNombres()
				+ ", getApellidoPaterno()=" + getApellidoPaterno()
				+ ", getApellidoMaterno()=" + getApellidoMaterno()
				+ ", getSexo()=" + getSexo() + ", getTipoDocumentoIdentidad()="
				+ getTipoDocumentoIdentidad()
				+ ", getNumeroDocumentoIdentidad()="
				+ getNumeroDocumentoIdentidad() + ", getFechaNacimiento()="
				+ getFechaNacimiento() + ", getDireccion()=" + getDireccion()
				+ ", getEmail()=" + getEmail() + ", getCodigo()=" + getCodigo()
				+ ", isActivo()=" + isActivo() + ", getUsuarioCreador()="
				+ getUsuarioCreador() + ", getFechaCreacion()="
				+ getFechaCreacion() + ", getUsuarioModificador()="
				+ getUsuarioModificador() + ", getFechaModificacion()="
				+ getFechaModificacion() + "]";
	}

}
