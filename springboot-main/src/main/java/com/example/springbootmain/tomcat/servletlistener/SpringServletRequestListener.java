package com.example.springbootmain.tomcat.servletlistener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebListener
public class SpringServletRequestListener implements ServletRequestListener {

    @Autowired
    RequestTimes requestTimes;

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("本次请求是第" + requestTimes.count.incrementAndGet() + "次请求");
    }

}
