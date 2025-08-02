package com.example.planow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PlanowApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanowApplication.class, args);
	}

}
