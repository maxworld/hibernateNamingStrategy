package com.example.namingstrategy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NamingStrategyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamingStrategyApplication.class, args);
	}

}
