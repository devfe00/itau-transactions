package com.itau.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.itau.desafioitau")
public class ItauTransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItauTransactionsApplication.class, args);
	}
}
