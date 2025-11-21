package com.point.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.point.system.data"})
@EntityScan(basePackages = {"com.point.system.data"})
@SpringBootApplication
public class PointSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointSystemApplication.class, args);
	}

}
