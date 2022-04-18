package com.example.spring.webclient.demospringclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoSpringClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringClientApplication.class, args);
	}

}
