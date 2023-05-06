package com.example.springbootmain.beanStudy.customlabel;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Handler用来声明自定义的Parser
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("user", new CustomerUserBeanDefinitionParser());
    }

}
