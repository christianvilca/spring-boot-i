package com.christianvilca.proyecto1.christian.bean;

import com.christianvilca.proyecto1.christian.ChristianApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDepdency {

    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingresado al metodo printWithDependency");
        int number = 1;
        LOGGER.debug("El numero enviado como parametro a la dependencia operation es: " + number); // Se desactiva automaticamente en produccion
        System.out.println(myOperation.sum(number));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
