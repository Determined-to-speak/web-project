package com.example.springbootmain.applicationContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vo.ApiResult;

import java.util.Arrays;

@RestController
@RequestMapping("ApplicationContextController")
public class ApplicationContextController {

    @Autowired
    ApplicationContext applicationContext;


    @GetMapping("testBeanFactory")
    public ApiResult testBeanFactory() {

        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));

        return new ApiResult();
    }
}
