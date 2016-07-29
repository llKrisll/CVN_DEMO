package com.synapsis.cvn.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.synapsis.cvn.persistence.repository")
@EntityScan(basePackages = "com.synapsis.cvn.persistence.entity")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public RequestContextListener requestContextListener() {
//        return new RequestContextListener();
//    }

    // @Override
    // public void onStartup(ServletContext servletContext) throws ServletException {
    // super.onStartup(servletContext);
    // servletContext.addListener(new RequestContextListener());
    // }

}