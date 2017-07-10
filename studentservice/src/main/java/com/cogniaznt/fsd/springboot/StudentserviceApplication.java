package com.cogniaznt.fsd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"com.cognizant.fsd.springboot.repositories","com.cognizant.fsd.springboot.controller","com.cognizant.fsd.springboot.service"})
@EnableMongoRepositories("com.cognizant.fsd.springboot.repositories")
@EnableDiscoveryClient
public class StudentserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentserviceApplication.class, args);
	}
}
