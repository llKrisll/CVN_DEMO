package com.synapsis.cvn.services;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.synapsis.cvn.services.interfaces.DateTimeService;

@Service
public class CurrentTimeDateTimeService implements DateTimeService {
	
	@Override
    public ZonedDateTime getCurrentDateAndTime() {
        return ZonedDateTime.now();
    }
}
