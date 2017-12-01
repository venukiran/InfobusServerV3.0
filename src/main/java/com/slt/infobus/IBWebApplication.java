package com.slt.infobus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SuppressWarnings("deprecation")
@Configuration
@ComponentScan(basePackages={"com.slt.infobus"})
@SpringBootApplication
public class IBWebApplication extends SpringBootServletInitializer {
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(IBWebApplication.class);
	    }
	
	public static void main(String args[]){
		SpringApplication.run(IBWebApplication.class,args);
	}	
}