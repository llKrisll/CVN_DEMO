package com.synapsis.cvn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan({ "orcom.synapsis.cvn.task" })
public class SpringTaskConfig {

}
