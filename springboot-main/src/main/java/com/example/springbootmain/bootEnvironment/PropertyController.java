package com.example.springbootmain.bootEnvironment;


import org.springframework.core.env.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vo.ApiResult;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Spring Property解析环境配置测试
 */

@RestController()  //这里的value是定义名称
@RequestMapping("/propertytest")  //注意一定是mapping才带路由
public class PropertyController {

    //这两个注解需要一起使用
//    @Qualifier(value = "CustomizeEnvironment")
//    @Autowired
    public ConfigurableEnvironment customerEnv;

    @Resource
    public ConfigurableEnvironment env;


    @GetMapping("/test")
    public String test() {
        return "This is a test";
    }

    @GetMapping("/propertySourcesTest")
    public ApiResult propertySourcesTest() {
        System.out.println(Arrays.toString(env.getActiveProfiles()));
        System.out.println("参数原本的配置为:" + env.getProperty("replace.config.data.test"));

        // ConfigurableEnvironment接口提供用于设置活动和默认配置文件以及操纵基础属性源的功能，允许客户端通过ConfigurablePropertyResolver超级接口设置和验证所需属性、自定义转换服务等。
        // 属性源操作属性源可能会被移除、重新排序或替换;
        // 其他属性源可能会通过从getPropertySources() 返回的MutablePropertySources实例添加。
        // 以下示例与StandardEnvironment的ConfigurableEnvironment的实现相反，但通常适用于任何实现，尽管特定的默认属性来源可能有所不同。

//      示例:
//      新增搜索优先级最高的属性源
//        ConfigurableEnvironment environment = new StandardEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();
        Map myMap = new HashMap();
        myMap.put("xyz", "myValue");
        propertySources.addFirst(new MapPropertySource("MY_MAP", myMap));

//      示例:
//      移除默认系统属性源
//        MutablePropertySources propertySources = environment.getPropertySources();
//        propertySources.remove(StandardEnvironment.SYSTEM_PROPERTIES_PROPERTY_SOURCE_NAME);

//      示例:
//      模拟测试
//        MutablePropertySources propertySources = environment.getPropertySources();
//        MockPropertySource mockEnvVars = new MockPropertySource().withProperty("xyz", "myValue");
//        propertySources.replace(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME, mockEnvVars);

        // 当ApplicationContext正在使用环境时，重要的是在调用context的refresh() 方法之前执行任何此类PropertySource操作。这样可以确保容器引导过程中所有属性源都可用，
        // 包括属性占位符配置器的使用。

        return new ApiResult();
    }


}
