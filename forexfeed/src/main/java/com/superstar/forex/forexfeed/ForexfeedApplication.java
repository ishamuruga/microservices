package com.superstar.forex.forexfeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient 
public class ForexfeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexfeedApplication.class, args);
	}

}
