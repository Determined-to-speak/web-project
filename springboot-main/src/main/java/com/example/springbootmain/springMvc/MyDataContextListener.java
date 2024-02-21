package com.example.springbootmain.springMvc;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.springframework.stereotype.Component;



/**
 * 自定义的 ServletContextListener
 */
@Component
public class MyDataContextListener implements ServletContextListener {

    private ServletContext context = null;

    public MyDataContextListener() {

    }


    /**
     * ServletContext启动以后，准备处理客户端请求
     *
     * @param event Information about the ServletContext that was initialized
     */
    public void contextInitialized(ServletContextEvent event) {

        context = event.getServletContext();
        //servlet中设置自己的属性
        context.setAttribute("myData", "this is MyData");

    }

    /**
     * @param event Information about the ServletContext that was destroyed
     */
    public void contextDestroyed(ServletContextEvent event) {
        context = null;
    }


}
