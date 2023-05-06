package com.example.springbootmain.beanStudy;

import com.example.springbootmain.beanStudy.bean.CustomerUser;
import com.example.springbootmain.beanStudy.bean.HelloWorld;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;


/**
 * XmlBeanFactory的相关练习
 */

public class XmlBeanFactoryTest {

    public static void main(String[] args) {

        //region 测试xml是否配置正确
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        System.out.println(obj.getB());
        //endregion

        //region 测试静态工厂创建Bean
        HelloWorld obj2 = (HelloWorld) factory.getBean("helloWorld2");
        System.out.println(obj2.getB());
        //endregion

        //region 测试动态工厂创建Bean
        HelloWorld obj3 = (HelloWorld) factory.getBean("helloWorld3");
        System.out.println(obj3.getB());
        //endregion

        //region  测试自定义的标签
        CustomerUser customerUser = (CustomerUser) factory.getBean("testCustomerUser");
        System.out.println("测试自定义的标签-------" + customerUser.getUserName() + "," + customerUser.getEmail() + "------------");
        //endregion

        Resource resource = new ClassPathResource("Beans.xml");
        try {
            InputStream inputStream = resource.getInputStream();
            System.out.println("查看inputStream");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
