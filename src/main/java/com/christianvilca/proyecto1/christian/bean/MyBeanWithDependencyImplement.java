package com.christianvilca.proyecto1.christian.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDepdency {

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int number = 1;
        System.out.println(myOperation.sum(number));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
