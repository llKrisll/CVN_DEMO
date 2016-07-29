package com.synapsis.cvn.persistence.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.synapsis.cvn.enums.Sexo;

@Entity
public class CaracteristicasFisicas extends AbstractBasicEntity{
	
	@GeneratedValue
    @Id
//    @Column(name="id")
    private Long id;
	
	private BigDecimal peso;
	
	private BigDecimal altura;
	
	private String edad;
	
	private String sexo;
	
	private BigDecimal factorActividad;
	
	private BigDecimal pliegueAbdominal;
	
	private BigDecimal pliegueSuprailiaco;
	
	private BigDecimal pliegueSubescapular;
	
	private BigDecimal pliegueTricipital;
	
	private BigDecimal pliegueCuadricipital;
	
	private BigDecimal plieguePeroneal;
	
	@ManyToOne
//	@JoinColumn(name="id",referencedColumnName="id")
	private Persona persona;

	public CaracteristicasFisicas() {
		super();
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public BigDecimal getFactorActividad() {
		return factorActividad;
	}

	public void setFactorActividad(BigDecimal factorActividad) {
		this.factorActividad = factorActividad;
	}

	public BigDecimal getPliegueAbdominal() {
		return pliegueAbdominal;
	}

	public void setPliegueAbdominal(BigDecimal pliegueAbdominal) {
		this.pliegueAbdominal = pliegueAbdominal;
	}

	public BigDecimal getPliegueSuprailiaco() {
		return pliegueSuprailiaco;
	}

	public void setPliegueSuprailiaco(BigDecimal pliegueSuprailiaco) {
		this.pliegueSuprailiaco = pliegueSuprailiaco;
	}

	public BigDecimal getPliegueSubescapular() {
		return pliegueSubescapular;
	}

	public void setPliegueSubescapular(BigDecimal pliegueSubescapular) {
		this.pliegueSubescapular = pliegueSubescapular;
	}

	public BigDecimal getPliegueTricipital() {
		return pliegueTricipital;
	}

	public void setPliegueTricipital(BigDecimal pliegueTricipital) {
		this.pliegueTricipital = pliegueTricipital;
	}

	public BigDecimal getPliegueCuadricipital() {
		return pliegueCuadricipital;
	}

	public void setPliegueCuadricipital(BigDecimal pliegueCuadricipital) {
		this.pliegueCuadricipital = pliegueCuadricipital;
	}

	public BigDecimal getPlieguePeroneal() {
		return plieguePeroneal;
	}

	public void setPlieguePeroneal(BigDecimal plieguePeroneal) {
		this.plieguePeroneal = plieguePeroneal;
	}
	
	public BigDecimal calcularPorcentajeGrasaCorporal(){
		if (Sexo.MASCULINO.getValor().equals(this.sexo)) {
			return new BigDecimal(3.64).add(sumaDePliegues().multiply(new BigDecimal(0.097)));
		}if (Sexo.FEMENINO.getValor().equals(this.sexo)) {
			return new BigDecimal(4.56).add(sumaDePliegues().multiply(new BigDecimal(0.146)));
		} else {
			return new BigDecimal(0);
		}
	}
	
	public BigDecimal sumaDePliegues(){
		return this.pliegueAbdominal.add(this.pliegueCuadricipital).add(this.plieguePeroneal)
				.add(this.pliegueSubescapular).add(this.pliegueSuprailiaco).add(this.pliegueTricipital);
	}
	
	public BigDecimal calcularPesoGrasoEnKilogramos(){		
		return this.peso.multiply(calcularPorcentajeGrasaCorporal()).multiply(new BigDecimal(0.01));
	}
	
	public BigDecimal calcularPesoMagroEnKilogramos(){		
		return this.peso.subtract(calcularPesoGrasoEnKilogramos());
	}

	
	
	
	
}
