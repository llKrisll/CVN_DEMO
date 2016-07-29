package com.synapsis.cvn.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.synapsis.cvn.persistence.entity.Persona;
import com.synapsis.cvn.persistence.repository.PersonaRepository;
import com.synapsis.cvn.services.interfaces.PersonaService;

public class PersonaServiceImpl extends AbstractCrudService<Persona, PersonaRepository> implements PersonaService{

	@Autowired
	@Override
	public void setRepo(PersonaRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Persona copy(Persona from, Persona to) {
		to = from;
        return to;
	}

	
}
