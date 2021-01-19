package com.justinswork.discoveryservercommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerCommerceApplication.class, args);
	}

}
