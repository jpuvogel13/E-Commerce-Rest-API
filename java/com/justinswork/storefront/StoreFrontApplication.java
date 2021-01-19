package com.justinswork.storefront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class StoreFrontApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(StoreFrontApplication.class, args);
	}

}
