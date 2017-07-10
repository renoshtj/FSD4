package com.cogniaznt.fsd.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.fsd.springboot.model.Student;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@RibbonClient(name="student-service" , configuration=RibbonConfiguration.class)
public class RibbonApplication {
	

    @Autowired
    private RestTemplate restTemplate;
	
	
	@RequestMapping("/students")
	public Student[] getAll(){
		Student[] students= restTemplate.getForObject("http://student-service/all", Student[].class);
		return students;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
}
