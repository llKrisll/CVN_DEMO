package com.synapsis.cvn.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.synapsis.cvn.persistence.entity.CaracteristicasFisicas;
import com.synapsis.cvn.persistence.repository.PersonaRepository;
import com.synapsis.cvn.services.interfaces.NutricionService;

public class NutricionServiceImpl implements NutricionService{

	@Autowired
	private PersonaRepository pr;
	
	@Autowired
	private CaracteristicasFisicas cf;
}
