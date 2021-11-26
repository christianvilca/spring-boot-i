package com.christianvilca.proyecto1.christian.caseuse;

import com.christianvilca.proyecto1.christian.entity.User;
import com.christianvilca.proyecto1.christian.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User newUser, long id) {
        return userService.update(newUser, id);
    }
}
