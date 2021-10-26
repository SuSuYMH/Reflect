package com.susu.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

//需求：编写一个框架，要求在不改变该类中任何代码的前提下，可以创建任意类的对象，并执行它的任意方法
public class KangJia {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        //创建Properties对象
        Properties pro = new Properties();
        //加载配置文件，转换为一个集合
        //先获取类加载器，再通过类加载器获得配置文件
        ClassLoader classLoader = KangJia.class.getClassLoader();
        InputStream inputStream =classLoader.getResourceAsStream("pro.properties");
        pro.load(inputStream);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //这两个就是一会要加载的类的类名以及方法的名称

        //3.加载该类进内存
        Class cls = Class.forName(className);

        //4.创建对象
        Object obj = cls.newInstance();

        //5.获取方法对象
        Method method = cls.getMethod(methodName);

        //6.执行方法
        method.invoke(obj);
    }
}
