package com.christianvilca.proyecto1.christian.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{

    @Override
    public void saludar() {
        System.out.printf("Hola Mundo desde mi componente 2");
    }
}
