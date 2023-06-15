package com.example.springbootmain.tomcat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

@Component
public class MyServletRequestListener implements ServletRequestListener {

    @Autowired
    RequestTimes requestTimes;

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("本次请求是第" + requestTimes.count.incrementAndGet() + "次请求");
    }

}
