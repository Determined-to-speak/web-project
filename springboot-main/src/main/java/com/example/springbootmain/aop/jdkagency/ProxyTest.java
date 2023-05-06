package com.example.springbootmain.aop.jdkagency;

import org.apache.catalina.User;

/**
 * JDK代理的测试类
 */
public class ProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) myInvocationHandler.getProxy();
        proxy.add();
    }
}
