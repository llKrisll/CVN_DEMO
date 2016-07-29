package com.cvn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.synapsis.cvn.config.Application;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ComponentScan(basePackages="com.synapsis.cvn.service")
@WebAppConfiguration
public class EmailTest {

	@Autowired
    private JavaMailSender mailSender;
	
	 @Test
    public void testSendingEmailAsync() throws Exception{
 
		final SimpleMailMessage email = new SimpleMailMessage();
	    email.setSubject("Prueba");
	    email.setText("Helloooo");
	    email.setTo("c.vargas.navarrete@gmail.com");
	    email.setFrom("krissk8.u.u@gmail.com");
	    mailSender.send(email);
		 
        //add the sleep to see the debug information
//        Thread.sleep(1000);
    }

}
