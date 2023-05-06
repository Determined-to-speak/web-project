package com.example.springbootmain.beanStudy;


import com.example.springbootmain.beanStudy.bean.HelloWorld;

import com.example.springbootmain.beanStudy.customapplication.MyClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 容器扩展 ApplicationContext
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        System.out.println(obj.getB());


        //region 使用自定义的Application
        //一定要设置启动参数 -DinitPropertySourcesTest=111 具体检查参数是否存在的逻辑为initPropertySources()
        System.setProperty("initPropertySourcesTest", "Test");
        ApplicationContext myFactory = new MyClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj2 = (HelloWorld) myFactory.getBean("helloWorld");
        System.out.println(obj2.getB());
        //endregion


    }

}
