package com.mastery.java.task;

import com.mastery.java.task.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SimpleWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebAppApplication.class, args);
	}



}
