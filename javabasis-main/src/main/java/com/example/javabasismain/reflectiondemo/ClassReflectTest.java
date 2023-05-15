package com.example.javabasismain.reflectiondemo;

import java.lang.reflect.Constructor;

public class ClassReflectTest {

    public static void main(String[] args) {
        Class clazz = Car.class;
        try {

            Car car1 = (Car) clazz.newInstance();
            car1.print();

            Constructor constructor2 = clazz.getDeclaredConstructor();
            constructor2.setAccessible(true);
            Car car2 = (Car) constructor2.newInstance();
            car2.print();

            Constructor constructor3 = clazz.getDeclaredConstructor(String.class);
            constructor3.setAccessible(true);
            Car car3 = (Car) constructor3.newInstance("lzj www");
            car3.print();


        } catch (Exception e) {
            System.out.println("反射发生异常");
        }

    }
}
