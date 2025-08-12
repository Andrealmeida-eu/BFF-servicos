package com.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlanGodoyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlanGodoyApplication.class, args);
	}

}
