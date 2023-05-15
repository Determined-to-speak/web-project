package com.example.springbootmain.bootEnvironment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 一定记得在spring.factories中配置processor
 * <p>
 * 这种方法是通过processor来对env进化环境的修改，算是比较容易想到的思路
 */

@Configuration
public class EnvironmentConfigByProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Assert.notNull(environment, "当前environment还未赋值");
        Map<String, Object> customerPro = new HashMap();
        customerPro.put("test-EnvironmentConfigByProcessor", "this is EnvironmentConfigByProcessor");
        environment.getPropertySources().addLast(new MapPropertySource("testProcessor", customerPro));
    }

}
