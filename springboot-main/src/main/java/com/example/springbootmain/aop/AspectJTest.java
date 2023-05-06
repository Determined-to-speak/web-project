package com.example.springbootmain.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;


/**
 * 自定义一个AOP的切面
 */
@Aspect
public class AspectJTest {

    @Pointcut("execution(* com.example.springbootmain.aop.pojo.TestBean.test(..))")
    public void test() {

    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("------beforeTest-------");
    }

    @After("test()")
    public void afterTest() {
        System.out.println("------afterTest-------");
    }

    @AfterReturning("test()")
    public void afterReturn(){
        System.out.println("------afterReturnTest-------");
    }


    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint point) {
        System.out.println("------before1-------");
        Object o = null;
        try {
            o = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }
}
