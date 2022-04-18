package com.example.spring.webclient.demospringclient.proxy;

import com.example.spring.webclient.demospringclient.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface ClientTwo {
    @GetMapping("/users")
    List<User> getUsers();

    @GetMapping("/users/{userID}")
    User getUser(@PathVariable("userID") int userID);
}
