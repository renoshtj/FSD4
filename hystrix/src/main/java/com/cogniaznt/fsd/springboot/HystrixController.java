package com.cogniaznt.fsd.springboot;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.fsd.springboot.model.Student;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableCircuitBreaker
public class HystrixController {
	
	RestTemplate restTemplate = new RestTemplate();
	

	@HystrixCommand(fallbackMethod="hystrixFallBack")
	@RequestMapping("/hystrix/students")
	public Student[] getAll(){
		Student[] students= restTemplate.getForObject("http://127.0.0.1:8095/students", Student[].class);
		System.out.println(students.length);
		return students;
	}
	
    @HystrixCommand(fallbackMethod = "fallback2")
	public Student[] hystrixFallBack(Throwable e){
    	 assert "getUserById command failed".equals(e.getMessage());
         throw new RuntimeException("fallback1 failed");
	
	}

}
