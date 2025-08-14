package com.org.invoiceGeneratorAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class InvoiceGeneratorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceGeneratorApiApplication.class, args);
	}

}
