package com.example.spring.webclient.demospringclient.controller;

import com.example.spring.webclient.demospringclient.entity.User;
import com.example.spring.webclient.demospringclient.proxy.ClientOne;
import com.example.spring.webclient.demospringclient.proxy.ClientThree;
import com.example.spring.webclient.demospringclient.proxy.ClientTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private ClientOne clientOne;

    @Autowired
    private ClientTwo clientTwo;

    @Autowired
    private ClientThree clientThree;

    @GetMapping("/users")
    public List<User> fetchUsers(){
        return clientOne.retrieveUsers();
    }

    @GetMapping("/users/{id}")
    public User fetchUser(@PathVariable int id){
        return clientOne.retrieveUser(id);
    }

    @GetMapping("/feign/users")
    public List<User> retrieveUsers(){
        return clientTwo.getUsers();
    }

    @GetMapping("/feign/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return clientTwo.getUser(id);
    }

    @GetMapping("/http-interface/users")
    public List<User> getUsers(){
        return clientThree.fetchUsers();
    }

    @GetMapping("/http-interface/users/{id}")
    public User getUser(@PathVariable int id) {
        return clientThree.fetchUser(id);
    }
}
