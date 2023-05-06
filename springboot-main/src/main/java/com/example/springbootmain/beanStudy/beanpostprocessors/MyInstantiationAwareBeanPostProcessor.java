package com.example.springbootmain.beanStudy.beanpostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("=====初始化bean " + beanName + " =====");
        return null;
    }


}
