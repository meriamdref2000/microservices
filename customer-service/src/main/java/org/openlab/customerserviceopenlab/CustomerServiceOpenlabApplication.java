package org.openlab.customerserviceopenlab;

import org.openlab.customerserviceopenlab.dto.RequestDTO;
import org.openlab.customerserviceopenlab.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceOpenlabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceOpenlabApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService){
		return args -> {
			customerService.saveCustomer(new RequestDTO("C01", "Merriam", "meriam@gmail.com"));
			customerService.saveCustomer(new RequestDTO("C02", "Mohamed", "mohamed@gmail.com"));
		};
	}

}
