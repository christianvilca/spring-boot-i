package com.christianvilca.proyecto1.christian.caseuse;

import com.christianvilca.proyecto1.christian.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void remove(long id) {
        userService.delete(id);
    }
}
