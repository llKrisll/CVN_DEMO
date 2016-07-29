package com.synapsis.cvn.web.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synapsis.cvn.services.interfaces.NutricionService;
import com.synapsis.cvn.web.dto.CaracteristicasFisicasDTO;

@Controller
@RequestMapping("/nutricion")
public class NutricionController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
    private NutricionService nutricionService;
	
	@RequestMapping(value = "/ingresar", method = RequestMethod.POST)
    public String editPost(@Valid CaracteristicasFisicasDTO caracteristicasFisicasDTO, BindingResult result) {
        if (result.hasFieldErrors()) {
            return "/user/edit";
        }
        
        return "redirect:/user/edit/?updated";
    }
}
