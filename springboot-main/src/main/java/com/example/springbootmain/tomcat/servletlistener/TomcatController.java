package com.example.springbootmain.tomcat.servletlistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vo.ApiResult;

import javax.servlet.ServletContext;

@RestController
@RequestMapping("/TomcatController")
public class TomcatController {

    @Autowired
    ServletContext servletContext;

    @GetMapping("RequestTimes")
    public ApiResult RequestTimes() {
        return new ApiResult();
    }

}
