package com.example.springbootmain.classLoad;

public class ClassLoadTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup());
    }
}
