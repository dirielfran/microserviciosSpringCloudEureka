package com.alfonso.app.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
//Se configura la aplicación Spring Boot actúe como un cliente de Eureka.
@EnableEurekaClient
@SpringBootApplication
//Se agrega los paquetes para el escaneo de la entidad
@EntityScan({"com.alfonso.commons.alumnos.models.entity",
				"com.alfonso.commons.examenes.models.entity",
				"com.alfonso.app.cursos.models.entity"})
public class MicroserviciosCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosCursosApplication.class, args);
	}

}
