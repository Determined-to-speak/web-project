package com.example.springbootmain.beanStudy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerUser {
    private String userName;
    private String email;
}
