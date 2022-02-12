package com.alfonso.app.eureka1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//Se habilita eureka
@EnableEurekaServer
@SpringBootApplication
public class MicroserviciosEureka1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosEureka1Application.class, args);
	}
}
