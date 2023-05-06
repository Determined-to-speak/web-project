package com.example.springbootmain.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vo.ApiResult;

import javax.servlet.ServletContext;

@RestController
@RequestMapping("MVCController")
public class MVCController {

    @Autowired
    ServletContext servletContext;

    /**
     * 测试自己写的 MyDataContextListener
     *
     * @return ApiResult
     */
    @GetMapping("testContextListener")
    public ApiResult testContextListener() {
        ApiResult apiResult = new ApiResult();

        String attribute = (String) servletContext.getAttribute("myData");
        apiResult.setData(attribute);

        return apiResult;
    }
}
