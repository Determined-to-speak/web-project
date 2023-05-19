package com.example.javabasismain.classloaddemo.customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 通过继承ClassLoader重写findClass方法实现打破双亲委派机制
 * 自定义的类加载器 OverrideMyClassLoader
 */
public class OverrideFindClassClassLoader extends ClassLoader {

    public File classFileDirectory;

    public OverrideFindClassClassLoader(File classFileDirectory) {
        if (classFileDirectory == null) {
            throw new RuntimeException("加载目录为空");
        }
        if (!classFileDirectory.isDirectory()) {
            throw new RuntimeException("必须是目录");
        }
        this.classFileDirectory = classFileDirectory;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> clazz = null;
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

    public File findClassFile(String name) {
        File[] file = classFileDirectory.listFiles();
        for (int i = 0; i < file.length; i++) {
            File cur = file[i];
            String fileName = cur.getName();
            if (fileName.endsWith(".class") && fileName.substring(0, fileName.lastIndexOf(".")).equals(name)) {
                return cur;
            }
        }
        return null;
    }
}
