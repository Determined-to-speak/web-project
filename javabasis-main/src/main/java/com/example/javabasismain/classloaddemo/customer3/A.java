package com.example.javabasismain.classloaddemo.customer3;

/**
 * 等待ClassLoader加载的类A
 */
public class A {

    public A() {
        System.out.println("---------- 加载到了类A3,当前路径为:" + this.getClass().getName());
    }

//    public void test(B b) {
//        System.out.println(b);
//    }
}
