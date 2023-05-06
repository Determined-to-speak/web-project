package com.example.springbootmain.beanStudy.customapplication;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自定义自己的ApplicationContext
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String... configLocations) {
        super(configLocations);
    }

    /**
     * 初始化上下文环境中的变量
     */
    protected void initPropertySources() {
        super.initPropertySources();
        //判断环境变量中是否有initPropertySourcesTest这个参数
        getEnvironment().setRequiredProperties("initPropertySourcesTest");
    }

}
