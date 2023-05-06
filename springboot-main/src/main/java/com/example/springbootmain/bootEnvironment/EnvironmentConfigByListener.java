package com.example.springbootmain.bootEnvironment;


import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.*;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;


/**
 * 一定记得在spring.factories中配置listener
 * <p>
 * 自定义修改environment的配置类
 * TODO 2022.3.6 本意想直接使用EnvironmentCapable但是失败了，有时间研究一下
 * <p>
 * 这种方式是通过监听event事件来刷新env
 */
@Configuration
public class EnvironmentConfigByListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        Assert.notNull(environment, "当前environment还未赋值");
        Map<String, Object> customerPro = new HashMap();
        customerPro.put("test-EnvironmentConfigByListener", "this is EnvironmentConfigByListener");
        environment.getPropertySources().addLast(new MapPropertySource("testListener", customerPro));
    }

}
