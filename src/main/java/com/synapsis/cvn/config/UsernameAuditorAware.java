package com.synapsis.cvn.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.synapsis.cvn.persistence.entity.User;

public class UsernameAuditorAware implements AuditorAware<String>{
	
	@Override
    public String getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
 
        if (authentication == null || !authentication.isAuthenticated()) {
            return "Prueba";
        }
 
        return ((User) authentication.getPrincipal()).getId().toString();
    }
}
