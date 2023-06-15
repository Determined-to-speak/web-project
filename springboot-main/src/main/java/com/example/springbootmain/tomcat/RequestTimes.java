package com.example.springbootmain.tomcat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class RequestTimes {
    public AtomicLong count = new AtomicLong(0);
}
