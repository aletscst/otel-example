package com.ammfec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LibraryLoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryLoansApplication.class, args);
	}

}
