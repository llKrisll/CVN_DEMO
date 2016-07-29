package com.synapsis.cvn.web.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.synapsis.cvn.persistence.entity.CaracteristicasFisicas;
import com.synapsis.cvn.persistence.entity.Direccion;
import com.synapsis.cvn.persistence.entity.TipoDocumentoIdentidad;

public class PersonaDTO extends AbstractBasicDTO{
	
	private String nombres;

    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private String sexo;
    
    private TipoDocumentoIdentidad tipoDocumentoIdentidad;
    
    private String numeroDocumentoIdentidad;
    
    private Date fechaNacimiento;
    
    private DireccionDTO direccionDTO;
    
    private List<CaracteristicasFisicas> caracteristicasFisicas;
    
    private String email;

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

	public DireccionDTO getDireccionDTO() {
		return direccionDTO;
	}

	public void setDireccionDTO(DireccionDTO direccionDTO) {
		this.direccionDTO = direccionDTO;
	}

	public List<CaracteristicasFisicas> getCaracteristicasFisicas() {
		return caracteristicasFisicas;
	}

	public void setCaracteristicasFisicas(
			List<CaracteristicasFisicas> caracteristicasFisicas) {
		this.caracteristicasFisicas = caracteristicasFisicas;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
