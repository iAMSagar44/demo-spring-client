package com.example.spring.webclient.demospringclient.proxy;

import com.example.spring.webclient.demospringclient.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class ClientOne {

    static final WebClient WEB_CLIENT = WebClient.create("https://jsonplaceholder.typicode.com");

    public List<User> retrieveUsers(){
        return WEB_CLIENT.get().uri("/users")
                .retrieve()
                .bodyToFlux(User.class)
                .collectList()
                .block();
    }

    public User retrieveUser(int id){
        return WEB_CLIENT.get().uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

}
