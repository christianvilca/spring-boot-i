package com.christianvilca.proyecto1.christian.configuration;

import com.christianvilca.proyecto1.christian.bean.MyBean;
import com.christianvilca.proyecto1.christian.bean.MyBeanWithProperties;
import com.christianvilca.proyecto1.christian.bean.MyBeanWithPropertiesImplement;
import com.christianvilca.proyecto1.christian.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {

    // @Value() -> llama a los valores o propiedades que hemos inicializado

    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties funtion() {
        return new MyBeanWithPropertiesImplement(name, apellido);
    }

}
