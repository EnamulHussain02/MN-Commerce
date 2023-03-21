package com.example.mnshopz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.example.mnshopz"})
@EnableJpaRepositories(basePackages = "com.example.mnshopz.repository")
//@EnableJpaRepositories(basePackages = {
//"com.example.mnshopz.repository" }, entityManagerFactoryRef = "dbEntityManager", transactionManagerRef = "dbTransactionManager")
@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages="com.example.mnshopz.entity")
public class MnshopzApplication {
	

	public static void main(String[] args) {
		
		SpringApplication.run(MnshopzApplication.class, args);
		
	}

}
