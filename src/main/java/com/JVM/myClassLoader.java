package com.JVM;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 吴喜华
 * @version 1.0
 * @date 2022/4/8 21:20
 */
public class myClassLoader  extends  ClassLoader{
       private  String classpath;

    public myClassLoader(String classpath) {
        this.classpath = classpath;
    }

    public  byte[] loadbyte(String name) throws IOException {
        String newname = name.replaceAll("\\.", "/");

        FileInputStream fileInputStream = new FileInputStream(classpath + "/" + newname+".class");
        int leng = fileInputStream.available();
        byte[] data = new byte[leng];

        fileInputStream.read(data);

        fileInputStream.close();

        return data;

    }

    protected Class<?> findClass(String name) throws ClassNotFoundException{
        try {
            byte[] loadbyte = loadbyte(name);
            return defineClass(name,loadbyte,0,loadbyte.length);

        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }

    }

    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                if (!name.startsWith("com.JVM.User")) {
                    c = this.getParent().loadClass(name);
                } else {
                    c = findClass(name);
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }



    public static void main(String[] args) {
        myClassLoader myClassLoader = new myClassLoader("D:/Test");
        try {
            Class<?> clazz = myClassLoader.loadClass("com.JVM.User");
            Object object = clazz.newInstance();
            Method getAge = clazz.getMethod("getAge", null);

            Object invoke = getAge.invoke(object, null);

            System.out.println(clazz.getClassLoader().getClass().getName());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
