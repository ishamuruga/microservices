package com.superstar.api.deposit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepositApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DepositApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("## IN RUNNING METHOD ####");
	}

}
