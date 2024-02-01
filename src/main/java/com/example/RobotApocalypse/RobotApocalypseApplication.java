package com.example.RobotApocalypse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.RobotApocalypse.repository")
@EntityScan("com.example.RobotApocalypse.entity")
public class RobotApocalypseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotApocalypseApplication.class, args);
	}

}
