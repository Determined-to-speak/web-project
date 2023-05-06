package com.example.springbootmain.beanStudy.customlabel;

import com.example.springbootmain.beanStudy.bean.CustomerUser;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;


/**
 * 自定义接口，用来解析XSD文件中的定义和组件定义
 */
public class CustomerUserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    //Element中对应的元素
    protected Class getBeanClass(Element element) {
        return CustomerUser.class;
    }

    //从element中提取对应的元素
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");

        //将提取的数据放到BeanDefinitionBuilder中，等到完成所有bean解析之后，统一注册到beanFactory中
        if (StringUtils.hasText(userName)) {
            builder.addPropertyValue("userName", userName);
        }
        if (StringUtils.hasText(email)) {
            builder.addPropertyValue("email", email);
        }

    }

}
