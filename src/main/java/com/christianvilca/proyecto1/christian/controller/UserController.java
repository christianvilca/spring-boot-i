package com.christianvilca.proyecto1.christian.controller;

import com.christianvilca.proyecto1.christian.caseuse.GetUser;
import com.christianvilca.proyecto1.christian.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* @RestController
* - Hereda de la notacion @Controller
* - Permite que los metodos que se creen se formateen con el formato JSON
* */

@RestController
@RequestMapping("/api/users")
public class UserController {

    private GetUser getUser;

    public UserController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }
}
