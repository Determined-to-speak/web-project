package com.example.javabasismain.classloaddemo;

public class ClassLoadTest {

    public static void main(String[] args) {

        ClassLoader classLoader = ClassLoadTest.class.getClassLoader();
        System.out.println(classLoader.getClass().getSimpleName());

        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1.getClass().getSimpleName());

        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

    }
}
