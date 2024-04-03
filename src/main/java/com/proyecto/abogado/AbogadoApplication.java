package com.proyecto.abogado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AbogadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbogadoApplication.class, args);
	}

}