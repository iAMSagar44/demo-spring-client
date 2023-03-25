package com.example.spring.webclient.demospringclient;

import com.example.spring.webclient.demospringclient.proxy.ClientThree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
@EnableFeignClients
public class DemoSpringClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringClientApplication.class, args);
	}

	//Bean for Client three (HTTP Interfaces)
	@Bean
	ClientThree clientThree() {
		WebClient client = WebClient.builder()
						.baseUrl("https://jsonplaceholder.typicode.com/")
						.defaultHeader("Accept","application/json")
						.build();
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
		return factory.createClient(ClientThree.class);
	}

}
