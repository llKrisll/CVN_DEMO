package com.synapsis.cvn.config;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.data.auditing.DateTimeProvider;

import com.synapsis.cvn.services.interfaces.DateTimeService;

public class AuditingDateTimeProvider implements DateTimeProvider{
	
	private final DateTimeService dateTimeService;
	 
    public AuditingDateTimeProvider(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }
 
    @Override
    public Calendar getNow() {
        return GregorianCalendar.from(dateTimeService.getCurrentDateAndTime());
    }
}