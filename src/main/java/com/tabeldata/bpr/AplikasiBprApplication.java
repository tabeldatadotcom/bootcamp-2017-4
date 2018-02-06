package com.tabeldata.bpr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AplikasiBprApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplikasiBprApplication.class, args);
	}
}
