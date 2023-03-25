package com.example.spring.webclient.demospringclient.proxy;

import com.example.spring.webclient.demospringclient.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface ClientThree {
    @GetExchange("/users")
    List<User> fetchUsers();
    @GetExchange("/users/{id}")
    User fetchUser(@PathVariable int id);
}
