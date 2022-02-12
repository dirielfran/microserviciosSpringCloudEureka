package com.alfonso.app.respuesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.alfonso.app.respuesta.models.entity",
				"com.alfonso.commons.alumnos.models.entity",
				"com.alfonso.commons.examenes.models.entity"})
public class MicroserviciosRespuestaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosRespuestaApplication.class, args);
	}

}
