package com.example.springbootmain.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vo.ApiResult;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("MVCController")
public class MvcController {

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

    @GetMapping("testBaseModule")
    public ApiResult testBaseModule() {
        ApiResult apiResult = new ApiResult();

        //region  通过ServletContext获得WebApplicationContext
        WebApplicationContext webApplicationContext = (WebApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        for (String beanName : webApplicationContext.getBeanDefinitionNames()) {
            //System.out.println(beanName);
        }
        //endregion

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("getContextPath: " + request.getContextPath());
        System.out.println("getRequestURI: " + request.getRequestURI());

        return apiResult;
    }

}
