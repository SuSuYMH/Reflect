package com.susu.annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

//需求：编写一个框架，要求在不改变该类中任何代码的前提下，可以创建任意类的对象，并执行它的任意方法
//这次不用配置文件的方法，而是用注解的方法
@Pro(className = "com.susu.annotation.Demo1", methodName = "show")//希望这个KuangJia类去执行这个类的这个方法(注意不论是这里还是配置文件中一定要写全类名！)
public class KangJia {
    public static void main(String[] args) throws Exception {
        //1.解析注解
        //获取该类的字节码文件对象
        Class<KangJia> kangJiaClass = KangJia.class;

        //2.获取上面的注释对象
        //其实就是在内存中生成了一个该注解接口的子类对象：就是获取了注解对象，他在内存中搞了一个类，这个类实现了这个接口，子类实现对象重写了接口中定义的抽象方法
        Pro annotation = kangJiaClass.getAnnotation(Pro.class);

        //3.调用注解对象中定义的抽象方法获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className);
        System.out.println(methodName);

        //下面的就一样了
        //4.加载该类进内存
        Class cls = Class.forName(className);

        //5.创建对象
        Object obj = cls.newInstance();

        //6.获取方法对象
        Method method = cls.getMethod(methodName);

        //7.执行方法
        method.invoke(obj);


    }
}
