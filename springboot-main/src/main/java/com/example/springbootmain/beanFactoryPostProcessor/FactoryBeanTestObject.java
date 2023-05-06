package com.example.springbootmain.beanFactoryPostProcessor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FactoryBeanTestObject {
    String a;
    String b;
}
