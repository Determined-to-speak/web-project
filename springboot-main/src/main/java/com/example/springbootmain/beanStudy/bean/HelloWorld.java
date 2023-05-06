package com.example.springbootmain.beanStudy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HelloWorld {
    int a = 1;
    String b = "mybatis/filefolding";
    Car car;
}
