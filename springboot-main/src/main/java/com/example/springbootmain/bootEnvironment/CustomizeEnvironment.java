package com.example.springbootmain.bootEnvironment;

import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义的一个environment，实际场景中的使用率应该不高，这里先注释掉
 */

//@Component(value = "CustomizeEnvironment")
public class CustomizeEnvironment extends AbstractEnvironment {
    @Override
    protected void customizePropertySources(MutablePropertySources propertySources) {
        super.customizePropertySources(propertySources);
        Map<String, Object> customerPro = new HashMap();
        customerPro.put("test-customer", "this is customer properties");
        propertySources.addLast(new MapPropertySource("mybatis/filefolding", customerPro));
    }

}
