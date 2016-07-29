package com.synapsis.cvn.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.synapsis.cvn.services.CurrentTimeDateTimeService;
import com.synapsis.cvn.services.interfaces.DateTimeService;

@Configuration
//@ComponentScan(basePackages = { "com.synapsis.cvn.event" })
@PropertySource("classpath:email.properties")
public class AppConfig {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private Environment env;

    // beans

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    

    @Bean
    public JavaMailSenderImpl javaMailSenderImpl() {
        final JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();

        try {
            mailSenderImpl.setHost(env.getRequiredProperty("smtp.host"));
            mailSenderImpl.setPort(env.getRequiredProperty("smtp.port", Integer.class));
            mailSenderImpl.setProtocol(env.getRequiredProperty("smtp.protocol"));
            mailSenderImpl.setUsername(env.getRequiredProperty("smtp.username"));
            mailSenderImpl.setPassword(env.getRequiredProperty("smtp.password"));
        } catch (IllegalStateException ise) {
            LOGGER.error("Could not resolve email.properties.  See email.properties.sample");
            throw ise;
        }
        final Properties javaMailProps = new Properties();
        javaMailProps.put("mail.smtp.auth", "true");
        javaMailProps.put("mail.smtp.starttls.enable", "true");
        javaMailProps.put("mail.debug", "true");
//        javaMailProps.put("mail.smtp.socketFactory.port", env.getRequiredProperty("smtp.port"));
//        javaMailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        javaMailProps.put("mail.smtp.socketFactory.fallback", "false");
        mailSenderImpl.setJavaMailProperties(javaMailProps);
        return mailSenderImpl;
    }
    
//    @Profile("application")
    @Bean
    public DateTimeService currentTimeDateTimeService() {
        return new CurrentTimeDateTimeService();
    }

}