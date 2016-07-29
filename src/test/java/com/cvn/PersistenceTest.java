package com.cvn;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.synapsis.cvn.config.Application;
import com.synapsis.cvn.enums.Sexo;
import com.synapsis.cvn.persistence.entity.Direccion;
import com.synapsis.cvn.persistence.entity.Persona;
import com.synapsis.cvn.persistence.entity.TipoDocumentoIdentidad;
import com.synapsis.cvn.persistence.repository.PersonaRepository;
import com.synapsis.cvn.persistence.repository.TipoDocumentoIdentidadRepository;

import static org.junit.Assert.*;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
//@ComponentScan(basePackages="com.synapsis.cvn.service")
@WebAppConfiguration
public class PersistenceTest {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private TipoDocumentoIdentidadRepository tipoDocumentoIdentidadRepository;
	
	@Test
    public void persistirPersona() {
		
		TipoDocumentoIdentidad tdi= new TipoDocumentoIdentidad();
        tdi.setCodigo("DNI");
        tdi.setDescripcion("DNI");
        tdi.setActivo(true);
        tipoDocumentoIdentidadRepository.save(tdi);
        
        Direccion  direccion=new Direccion();
        direccion.setPais("PERU");
        direccion.setProvincia("LIMA");
        direccion.setCiudad("LIMA");
        direccion.setDescripcion("AV. SIEMPRE VIVA NRO. 123");
        direccion.setReferencia("POR AHI");
        
        Persona persona = new Persona();
        persona.setNombres("CRISTIAN MARCELO");
        persona.setApellidoPaterno("VARGAS");
        persona.setApellidoMaterno("NAVARRETE");
        persona.setSexo(Sexo.MASCULINO.getValor());
        
        Calendar c1 = GregorianCalendar.getInstance();
        c1.set(1989, Calendar.MARCH, 29);
        persona.setFechaNacimiento(c1.getTime());
        persona.setTipoDocumentoIdentidad(tdi);
        persona.setNumeroDocumentoIdentidad("12548965");
        persona.setDireccion(direccion);
        persona.setActivo(true);
        
//        Persona persona3=personaRepository.save(persona);
//        System.out.println( persona3.toString());
        
        assertNotNull(personaRepository.save(persona));
        
        persona.setNumeroDocumentoIdentidad("78956425");
        
        assertNotNull(personaRepository.save(persona));
        
        List<Persona> personaList=personaRepository.findByNombresContainingIgnoreCase("CRISTIAN");
        
        for (Persona persona2 : personaList) {
			System.out.println(persona2.toString());
	        int row= personaRepository.activarPersona(false, persona2.getId());
	        System.out.println("Row afectadas: "+row);
	        System.out.println(personaRepository.findOne(persona2.getId()).isActivo());
		}
        
        
    }
	
}
