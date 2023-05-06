package com.example.springbootmain.beanStudy.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component
public class Car {

    @Value("init c")
    String c;
    int d;

    public Car(String c, int d) {
        this.c = c;
        this.d = d;
    }

}
