package com.example.javabasismain.threaddemo;

public class RuntimeDemo {

    public static void main(String[] args) {
        int result = Runtime.getRuntime().availableProcessors();
        System.out.println("当前机器的线程数为: " + result);
    }

}
