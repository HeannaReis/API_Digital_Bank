package com.companye.DigitalBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.validation.annotation.Validated;

@EnableFeignClients
@SpringBootApplication
@Validated
public class DigitalBankApplication {

	public static void main(String[] args) {

		SpringApplication.run(DigitalBankApplication.class, args);
	}

}
