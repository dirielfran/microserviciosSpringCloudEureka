package com.alfonso.app.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.EnableMBeanExport;
//Se habilita eureka
@EnableEurekaServer
@SpringBootApplication
public class MicroserviciosEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosEurekaApplication.class, args);
	}

}
