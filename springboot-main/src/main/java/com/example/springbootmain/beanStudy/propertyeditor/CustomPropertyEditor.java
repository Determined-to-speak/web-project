package com.example.springbootmain.beanStudy.propertyeditor;

import com.example.springbootmain.beanStudy.bean.Car;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/**
 * 自定义的字段编辑器,对Car类型的字段自动进行赋值
 */
@Component
public class CustomPropertyEditor extends PropertyEditorSupport {

    public void setValue(Object value) {
        if (value instanceof Car) {
            ((Car) value).setC("pass property editor");
        }
        super.setValue(value);
    }

}
