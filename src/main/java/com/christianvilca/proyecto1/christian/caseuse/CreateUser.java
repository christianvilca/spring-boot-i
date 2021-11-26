package com.christianvilca.proyecto1.christian.caseuse;

import com.christianvilca.proyecto1.christian.entity.User;
import com.christianvilca.proyecto1.christian.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
