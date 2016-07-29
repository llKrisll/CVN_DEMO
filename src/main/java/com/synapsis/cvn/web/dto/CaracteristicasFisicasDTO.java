package com.synapsis.cvn.web.dto;

import java.math.BigDecimal;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.synapsis.cvn.enums.Sexo;
import com.synapsis.cvn.persistence.entity.Persona;

public class CaracteristicasFisicasDTO extends AbstractBasicDTO{
	
	@NotNull
    @Size(min = 1)	
	private BigDecimal peso;
	
	@NotNull
	private BigDecimal altura;
	
	@NotNull
	private String edad;
	
	@NotNull
	private Sexo sexo;
	
	@NotNull
	private BigDecimal factorActividad;
	
	@NotNull
	private BigDecimal pliegueAbdominal;
	
	@NotNull
	private BigDecimal pliegueSuprailiaco;
	
	@NotNull
	private BigDecimal pliegueSubescapular;
	
	@NotNull
	private BigDecimal pliegueTricipital;
	
	@NotNull
	private BigDecimal pliegueCuadricipital;
	
	@NotNull
	private BigDecimal plieguePeroneal;
	
	@NotNull
	private PersonaDTO personaDTO;
}
