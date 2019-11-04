package com.ml.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ml.repository")
@ComponentScan("com.ml")
@EntityScan("com.ml.*")
public class SystemSolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemSolarApplication.class, args);
	}
}
