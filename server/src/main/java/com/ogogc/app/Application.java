package com.ogogc.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration  
public class Application extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		// TODO Auto-generated method stub
		return application.sources(applicationClass);
	}
	public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }
	private static Class<Application> applicationClass = Application.class;
}
