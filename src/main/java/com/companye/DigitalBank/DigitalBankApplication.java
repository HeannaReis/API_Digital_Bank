package com.companye.DigitalBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;


@SpringBootApplication
@Validated
public class DigitalBankApplication {

	public static void main(String[] args) {

		SpringApplication.run(DigitalBankApplication.class, args);
	}

}
