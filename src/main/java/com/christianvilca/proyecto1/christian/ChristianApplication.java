package com.christianvilca.proyecto1.christian;

import com.christianvilca.proyecto1.christian.bean.MyBean;
import com.christianvilca.proyecto1.christian.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChristianApplication implements CommandLineRunner {

    private ComponentDependency componentDependency;
    private MyBean myBean;

    public ChristianApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(ChristianApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.saludar();
        myBean.print();
    }
}
