package com.kdw.eip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EipApplication {

	public static void main(String[] args) {
		SpringApplication.run(EipApplication.class, args);
	}

}
