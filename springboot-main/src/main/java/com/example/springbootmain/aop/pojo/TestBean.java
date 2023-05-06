package com.example.springbootmain.aop.pojo;

/**
 * 普通的pojo用来测试切面
 */
public class TestBean {

    private String testStr = "testStr";

    public void test() {
        System.out.println("mybatis/filefolding");
    }

    public TestBean() {
    }

    public TestBean(String testStr) {
        this.testStr = testStr;
    }


    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
}
