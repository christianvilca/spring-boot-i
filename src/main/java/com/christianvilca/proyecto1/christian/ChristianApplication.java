package com.christianvilca.proyecto1.christian;

import com.christianvilca.proyecto1.christian.bean.MyBean;
import com.christianvilca.proyecto1.christian.bean.MyBeanWithDepdency;
import com.christianvilca.proyecto1.christian.bean.MyBeanWithProperties;
import com.christianvilca.proyecto1.christian.component.ComponentDependency;
import com.christianvilca.proyecto1.christian.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChristianApplication implements CommandLineRunner {

    private final Log LOGGER = LogFactory.getLog(ChristianApplication.class);

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDepdency myBeanWithDepdency;
    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;

    public ChristianApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDepdency myBeanWithDepdency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDepdency = myBeanWithDepdency;
        this.myBeanWithProperties=  myBeanWithProperties;
        this.userPojo = userPojo;
    }

    public static void main(String[] args) {
        SpringApplication.run(ChristianApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.saludar();                          // Hola Mundo desde mi componente 2
        myBean.print();                                         // Hola desde mi implementacion propia del bean 2
        myBeanWithDepdency.printWithDependency();               // Hola desde la implementacion de un bean con dependencia
        System.out.println(myBeanWithProperties.function());    // christian vilca
        System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword());    // test@mai.com-1234

        // puede estar dentro del try catch
        try {
            int value = 10/0;
            LOGGER.debug("Mi valor: " + value);
        }catch (Exception e){
            LOGGER.error("Esto es un error al divideri por cero " + e.getStackTrace());
        }
        LOGGER.error("Esto es un error del aplicativo");       // 2021-11-24 09:43:06.777 ERROR 14132 --- [  restartedMain] c.c.p.christian.ChristianApplication     : Esto es un error del aplicactivo
    }
}
