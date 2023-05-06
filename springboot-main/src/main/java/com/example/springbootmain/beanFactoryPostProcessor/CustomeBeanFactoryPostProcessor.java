package com.example.springbootmain.beanFactoryPostProcessor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义beanfactory来对bean字段上的敏感词进行过滤
 */
//@Configuration
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public Set<String> keywords;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beannames = beanFactory.getBeanDefinitionNames();
        for (String beanname : beannames) {
            BeanDefinition bd = beanFactory.getBeanDefinition(beanname);
            StringValueResolver stringValueResolver = new StringValueResolver() {
                @Override
                public String resolveStringValue(String strVal) {
                    if (keywords.contains(strVal)) {
                        return "******";
                    }
                    return strVal;
                }
            };
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(stringValueResolver);
            visitor.visitBeanDefinition(bd);
        }
    }

}
