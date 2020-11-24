package com.alfonso.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//Se habilita como cliente de eureka
@EnableEurekaClient
@SpringBootApplication
//Se agrega los paquetes para el escaneo de la entidad
@EntityScan({"com.alfonso.commons.alumnos.models.entity"})
public class MicroserviciosUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosUsuariosApplication.class, args);
	}

}
