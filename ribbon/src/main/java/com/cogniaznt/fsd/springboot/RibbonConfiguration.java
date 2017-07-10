package com.cogniaznt.fsd.springboot;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfiguration {
	
	    @LoadBalanced
	    @Bean
	    RestTemplate restTemplate() {
	        return new RestTemplate();
	    }

}
