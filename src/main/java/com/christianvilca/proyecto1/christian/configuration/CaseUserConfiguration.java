package com.christianvilca.proyecto1.christian.configuration;

import com.christianvilca.proyecto1.christian.caseuse.GetUser;
import com.christianvilca.proyecto1.christian.caseuse.GetUserImplement;
import com.christianvilca.proyecto1.christian.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUserConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
