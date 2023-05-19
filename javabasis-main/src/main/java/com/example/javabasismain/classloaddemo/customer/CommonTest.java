package com.example.javabasismain.classloaddemo.customer;

import java.io.File;

public class CommonTest {

    public void test() throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        contextClassLoader.loadClass("A");
        System.out.println("success");

    }

    public static void main(String[] args) throws ClassNotFoundException {

        //region 默认类加载器加载当前项目下的类
        ClassLoader threadClassLoader = Thread.currentThread().getContextClassLoader();
        Class<?> aclazz = threadClassLoader.loadClass("com.example.javabasismain.classloaddemo.customer.A");
        try {
            aclazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        System.out.println("默认加载当前项目中的class类：" + aclazz);
        //endregion

        //region 自定义的加载器加载其他目录下的类
        ClassLoader myClassLoader = new MyClassLoader(new File("E:\\IdeaProjects\\classloadtest"));
        Class<?> aOtherClass = myClassLoader.loadClass("A");
        try {
            aOtherClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        System.out.println("加载其他项目中的class类：" + aOtherClass);
        //endregion

    }

}
