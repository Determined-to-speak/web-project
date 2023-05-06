package com.example.springbootmain.beanStudy.propertyeditor;

import com.example.springbootmain.beanStudy.bean.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 注册CustomPropertyEditor在spring中使用
 */

@Component
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar, BeanFactoryPostProcessor {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Car.class, new CustomPropertyEditor());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.addPropertyEditorRegistrar(this);
    }
}
