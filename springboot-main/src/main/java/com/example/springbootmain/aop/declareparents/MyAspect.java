package com.example.springbootmain.aop.declareparents;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;


/**
 * 用来增强某一个对象（比如对一个service加入一个新的方法并且不实现接口）
 */
@Aspect
@Component
public class MyAspect {


    /**
     * value:增强的目标类，defaultImpl:默认的增强实现
     */
    @DeclareParents(value = "com.example.springbootmain.aop.declareparents.HelloServiceImpl", defaultImpl = HelloParamServiceImpl.class)
    public HelloParamService helloParamService;

}
