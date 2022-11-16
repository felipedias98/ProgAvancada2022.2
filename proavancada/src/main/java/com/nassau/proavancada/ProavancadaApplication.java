package com.nassau.proavancada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ProavancadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProavancadaApplication.class, args);
	}

}
