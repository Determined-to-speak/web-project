package com.example.javabasismain.classload;

import java.util.Scanner;

public class ClassLoadMainB {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup());
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {

        }
    }
}
