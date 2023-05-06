package com.example.springbootmain.aop;

import com.example.springbootmain.aop.declareparents.HelloParamService;
import com.example.springbootmain.aop.declareparents.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AopTestController")
public class AopTestController {

    @Autowired
    HelloServiceImpl helloService;

    @GetMapping("/testDeclareParents")
    public void testDeclareParents() {
        HelloParamService helloParamService = (HelloParamService) helloService;
        System.out.println(helloParamService.printOut("JAVA"));
    }
}
