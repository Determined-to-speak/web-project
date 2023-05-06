package com.example.springbootmain.aop.cglibagency;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理实现类
 */
public class EnhancerDemo {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        EnhancerDemo enhancerDemo = (EnhancerDemo) enhancer.create();
        enhancerDemo.test();
        System.out.println(enhancerDemo);

    }

    public void test() {
        System.out.println("EnhancerDemo test()");
    }


    public static class MethodInterceptorImpl implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.err.println("Before invoke :" + method);
            Object result = methodProxy.invokeSuper(o, objects);
            System.err.println("After invoke :" + method);
            return result;
        }

    }

}
