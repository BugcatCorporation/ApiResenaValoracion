package com.bugcat.apiResVal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class ApiResenaValoracionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiResenaValoracionApplication.class, args);
	}

}
