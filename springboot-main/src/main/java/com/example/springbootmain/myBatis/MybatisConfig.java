package com.example.springbootmain.myBatis;


import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@ConditionalOnProperty(prefix = "start", name = "mybatis", havingValue = "true")
public class MybatisConfig {

}
