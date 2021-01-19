package com.justinswork.customercart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.justinswork.customercart.models.CartProducts;
import com.justinswork.customercart.models.CartCartDetails;

@SpringBootApplication
@EnableEurekaClient
public class CustomerCartApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerCartApplication.class, args);
	}

}
