package com.example.springbootmain.beanStudy;

import com.example.springbootmain.beanStudy.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vo.ApiResult;


@RestController(value = "CustomPropertyEditorController")  //这里的value是定义名称
@RequestMapping("/CustomPropertyEditorController")
public class CustomPropertyEditorController {

    @Autowired
    Car car;

    /**
     * TODO 测试未生效
     *
     * @return
     */
    @GetMapping("testCustomPropertyEditor")
    public ApiResult testCustomPropertyEditor() {
        System.out.println("testCustomPropertyEditor1: " + car.getC());
        car.setC("test c");
        System.out.println("testCustomPropertyEditor2: " + car.getC());
        return new ApiResult();
    }

}
