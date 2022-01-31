package com.cardealership.cardealership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.cardealership")
public class CardealershipApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder 
configure(SpringApplicationBuilder application) {
		return application.sources(CardealershipApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CardealershipApplication.class, args);
	}
}
