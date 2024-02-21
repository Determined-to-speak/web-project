package com.example.springbootmain.beanFactoryPostProcessor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vo.ApiResult;

@RestController(value = "CustomeBeanFactoryPostProcessorController")  //这里的value是定义名称
@RequestMapping("/CustomeBeanFactoryPostProcessorController")
public class CustomeBeanFactoryPostProcessorController {

    @Autowired
    FactoryBeanTestObject factoryBeanTestObject;


    @GetMapping("testFactoryPostProcessor")
    public ApiResult testFactoryPostProcessor() {
        System.out.println("testFactoryPostProcessor1  " + factoryBeanTestObject.getA() + factoryBeanTestObject.getB());
        factoryBeanTestObject.setA("av");
        System.out.println("testFactoryPostProcessor2  " + factoryBeanTestObject.getA() + factoryBeanTestObject.getB());
        return new ApiResult(200, factoryBeanTestObject.getA());
    }

    public static void main(String[] args) {
        ConfigurableListableBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
        CustomeBeanFactoryPostProcessor factoryPostProcessor = (CustomeBeanFactoryPostProcessor) factory.getBean("CustomeBeanFactoryPostProcessor");


//        FactoryBeanTest factoryBeanTest1 = (FactoryBeanTest) factory.getBean("FactoryBeanTest");
//        System.out.println("testFactoryPostProcessor1  " + factoryBeanTest1.getA() + factoryBeanTest1.getB());
        factoryPostProcessor.postProcessBeanFactory(factory);
        FactoryBeanTestObject factoryBeanTestObject2 = (FactoryBeanTestObject) factory.getBean("FactoryBeanTest");
        System.out.println("testFactoryPostProcessor2  " + factoryBeanTestObject2.getA() + factoryBeanTestObject2.getB());

    }

}
