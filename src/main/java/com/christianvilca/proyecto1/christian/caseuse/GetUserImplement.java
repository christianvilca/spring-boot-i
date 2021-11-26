package com.christianvilca.proyecto1.christian.caseuse;

import com.christianvilca.proyecto1.christian.entity.User;
import com.christianvilca.proyecto1.christian.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser {

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
