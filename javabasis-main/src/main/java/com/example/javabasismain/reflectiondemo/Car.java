package com.example.javabasismain.reflectiondemo;


import lombok.Data;

@Data
public class Car {

    String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
        System.out.println(this.name);
    }

    public void print() {
        System.out.println("Car class test!");
    }

}
