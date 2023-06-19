package com.example.javabasismain.classloaddemo.customer2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 通过继承ClassLoader重写loadClass方法实现打破双亲委派机制
 * <p>
 * 自定义的类加载器
 */
public class MyClassLoader extends ClassLoader {

    public File classFileDirectory;

    public MyClassLoader(File classFileDirectory) {
        if (classFileDirectory == null) {
            throw new RuntimeException("加载目录为空");
        }
        if (!classFileDirectory.isDirectory()) {
            throw new RuntimeException("必须是目录");
        }
        this.classFileDirectory = classFileDirectory;
    }

    /**
     * 重写loadClass方法
     *
     * @param name    The <a href="#name">binary name</a> of the class
     * @param resolve If <tt>true</tt> then resolve the class
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz;

        //region 先尝试调用父类的loadClass方法
        try {
            clazz = super.loadClass(name, false);
            if (clazz != null) {
                return clazz;
            }
        } catch (Exception e) {
        }
        //endregion

        File classFile = findClassFile(name);
        try {
            FileInputStream fileInputStream = new FileInputStream(classFile);
            byte[] bytes = new byte[(int) classFile.length()];
            fileInputStream.read(bytes);
            clazz = defineClass(name, bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clazz;
    }

    //获取名为name的类文件
    public File findClassFile(String name) {
        File[] file = classFileDirectory.listFiles();
        for (int i = 0; i < file.length; i++) {
            File cur = file[i];
            String fileName = cur.getName();
            //下面的这个subString感觉很怪，不应该是从最后一次.出现的位置开始，到整个字符串的结尾么？？？
            //解决疑惑：上面的fileName返回的数据为 A.class，具体debug一下，这里的getName方法获得到的应该是除目录后的剩余字符串
            if (fileName.endsWith(".class") && fileName.substring(0, fileName.lastIndexOf(".")).equals(name)) {
                return cur;
            }
        }
        return null;
    }


}
