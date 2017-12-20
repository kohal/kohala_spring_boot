package com.reflex.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @Author: xuyongjian
 * @Date: 2017/9/1
 */
public class ClassLoaderTest {
    public static void main(String[] args) {


        {
            ClassLoader myLoader = new ClassLoader() {

//                不重写loadClass的话，因双亲委派模型被父加载器加载，导致最后的结果还是true
                @Override
                public Class<?> loadClass(String name) throws ClassNotFoundException {

                    try {
                        String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                        InputStream is = getClass().getResourceAsStream(fileName);
                        if (is == null) {
                            return super.loadClass(name);
                        }
                        byte[] b = new byte[is.available()];
                        is.read(b);
                        return defineClass(name, b, 0, b.length);
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new ClassNotFoundException(name);
                    }
                }

                @Override
                protected Class<?> findClass(String name) throws ClassNotFoundException {
                    return null ;
                }
            };


            Object obj = null;
            Object obj1 = null;
            URL path = null;
            URL path1 = null;


            try {
                obj=Class.forName("com.reflex.service.ClassLoaderTest").newInstance();
                obj1 = myLoader.loadClass("com.reflex.service.ClassLoaderTest").newInstance();
                path= myLoader.getResource("./");
                path1=ClassLoader.getSystemClassLoader().getResource("./");

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(obj.getClass());
            System.out.println(obj instanceof ClassLoaderTest);
            System.out.println(obj1 instanceof ClassLoaderTest );

            System.out.println(path);
            System.out.println(path1);
            System.out.println(System.getProperty("user.dir"));


        }
    }
}