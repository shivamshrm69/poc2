package com.poc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.poc2.*"})
public class Poc2Application {

	public static void main(String[] args) {
		SpringApplication.run(Poc2Application.class, args);
	}

}
