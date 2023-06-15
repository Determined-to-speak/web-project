package com.example.springbootmain.tomcat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vo.ApiResult;

@RestController
@RequestMapping("/TomcatController")
public class TomcatController {

    @GetMapping("RequestTimes")
    public ApiResult RequestTimes() {
        return new ApiResult();
    }

}
