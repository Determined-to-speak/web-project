package com.example.springbootmain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication
public class SpringbootMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMainApplication.class, args);
        System.out.println(Thread.currentThread().getContextClassLoader());
    }

}
