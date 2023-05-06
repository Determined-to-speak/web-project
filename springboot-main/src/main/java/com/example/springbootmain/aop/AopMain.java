package com.example.springbootmain.aop;

import com.example.springbootmain.aop.pojo.TestBean;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

    //注意此处test()方法切面的执行顺序，感觉网上的图是错的

    //------before1-------
    //------beforeTest-------
    //test
    //------afterReturnTest-------
    //------afterTest-------
    //after1


    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
        TestBean testBean = (TestBean) factory.getBean("test");
        testBean.test();
    }

}
