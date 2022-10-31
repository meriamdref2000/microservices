package org.openlab.billingserviceopenlab;

import org.openlab.billingserviceopenlab.dto.InvoiceRequestDTO;
import org.openlab.billingserviceopenlab.service.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceOpenlabApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceOpenlabApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(InvoiceService invoiceService){
		return args ->{
			invoiceService.saveInvoice(new InvoiceRequestDTO(BigDecimal.valueOf(98000), "C01"));
			invoiceService.saveInvoice(new InvoiceRequestDTO(BigDecimal.valueOf(100000), "C02"));
		};
	}
}
