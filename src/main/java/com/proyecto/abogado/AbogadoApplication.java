package com.proyecto.abogado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class AbogadoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AbogadoApplication.class, args);
		Files.createDirectories(Paths.get("C:/Archivos_abogado"));
	}

}
