package com.example.springbootmain.tomcat.servletlistener;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 当前pod的请求次数
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
public class RequestTimes {
    public AtomicLong count = new AtomicLong(0);
}
