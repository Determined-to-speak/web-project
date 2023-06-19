package com.example.javabasismain.classloaddemo;

import com.example.javabasismain.classloaddemo.customer2.MyClassLoader;
import com.example.javabasismain.classloaddemo.customer3.OverrideFindClassClassLoader;

import java.io.File;

public class MyClassLoaderTest {

    public void test() throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        contextClassLoader.loadClass("A");
        System.out.println("success");

    }

    public static void main(String[] args) throws ClassNotFoundException {

        //region 默认类加载器加载当前项目下的类
        ClassLoader threadClassLoader = Thread.currentThread().getContextClassLoader();
        Class<?> aclazz = threadClassLoader.loadClass("com.example.javabasismain.classloaddemo.customer1.A");
        try {
            aclazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        System.out.println("默认加载当前项目中的class类：" + aclazz);
        //endregion

        //下面的两个文件，另外搞两个测试类，分别编译出class文件

        //region 自定义的加载器加载其他目录下的类  MyClassLoader
        ClassLoader myClassLoader = new MyClassLoader(new File("E:\\IdeaProjects\\classloadertest"));
        Class<?> aOtherClass = myClassLoader.loadClass("A");
        try {
            aOtherClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        System.out.println("MyClassLoader加载其他项目中的class类：" + aOtherClass);
        //endregion


        //region 自定义的加载器加载其他目录下的类  OverrideFindClassClassLoader
        ClassLoader myClassLoader1 = new OverrideFindClassClassLoader(new File("E:\\IdeaProjects\\classloadertest"));
        Class<?> aOtherClass1 = myClassLoader1.loadClass("A");
        try {
            aOtherClass1.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        System.out.println("OverrideFindClassClassLoader加载其他项目中的class类：" + aOtherClass1);
        //endregion

    }

}
