package com.demon.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.demon.user.repository")
public class DemonUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemonUserApplication.class, args);
	}

}
