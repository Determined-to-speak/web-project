package com.example.springbootmain.beanStudy;


import com.example.springbootmain.beanStudy.bean.HelloWorld;

/**
 * 通过工厂模式创建Bean
 */
public class HelloWorldFactory {
    public static HelloWorld createHelloWorld() {
        System.out.println("静态工厂创建HelloWorld");
        return new HelloWorld();
    }

    public HelloWorld createHelloWorld2() {
        System.out.println("实例工厂创建HelloWorld");
        return new HelloWorld();
    }
}
