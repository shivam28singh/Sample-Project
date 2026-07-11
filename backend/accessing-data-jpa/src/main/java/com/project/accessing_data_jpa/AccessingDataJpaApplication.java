package com.project.accessing_data_jpa;

import   org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger logger = LoggerFactory.getLogger(AccessingDataJpaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository){
		return (args)->{
              repository.save(new Customer("Shivam","Singh"));
			  logger.info("Customers found with findAll():");
			  repository.findAll().forEach(customer -> {
				  logger.info(customer.toString());
			  });
		};
	}

}
