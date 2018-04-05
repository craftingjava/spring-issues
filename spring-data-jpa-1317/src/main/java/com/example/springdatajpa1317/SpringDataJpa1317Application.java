package com.example.springdatajpa1317;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringDataJpa1317Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpa1317Application.class, args);
	}
}
