package com.christianvilca.proyecto1.christian;

import com.christianvilca.proyecto1.christian.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChristianApplication implements CommandLineRunner {

    private ComponentDependency componentDependency;

    public ChristianApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency) {
        this.componentDependency = componentDependency;
    }

    public static void main(String[] args) {
        SpringApplication.run(ChristianApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.saludar();
    }
}
