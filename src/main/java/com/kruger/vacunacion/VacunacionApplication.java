package com.kruger.vacunacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kruger.vacunacion.doc.SwaggerConfig;

@SpringBootApplication
public class VacunacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacunacionApplication.class, args);
		SwaggerConfig swg = new SwaggerConfig();
		swg.api();
	}

}
