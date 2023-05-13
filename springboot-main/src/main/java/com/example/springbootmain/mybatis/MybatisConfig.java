package com.example.springbootmain.mybatis;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@ConditionalOnProperty(prefix = "start", name = "mybatis", havingValue = "true")
public class MybatisConfig {

}
