package com.example.mnshopz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.mnshopz"})
@SpringBootApplication
public class MnshopzApplication {
	

	public static void main(String[] args) {
		
		SpringApplication.run(MnshopzApplication.class, args);
		
	}

}
