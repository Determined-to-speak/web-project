package com.example.springbootmain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootTest
class SpringbootMainApplicationTests {

    @Autowired
    public Environment env;

    @Test
    void contextLoads() {
        System.out.println(Arrays.toString(env.getActiveProfiles()));
        System.out.println(env.getProperty("replace.config.data.test"));
    }

}
