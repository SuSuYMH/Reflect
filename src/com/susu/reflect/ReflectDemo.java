package com.susu.reflect;

import com.susu.domain.Persion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //得到类对象
        Class persionClass = Persion.class;


        /**
        * 玩成员变量
        */
        //获取成员变量
        Field[] fields = persionClass.getFields();
        for( Field field : fields)
        {
            System.out.println(field);
        }

        Field a =persionClass.getField("a");
        //获取成员变量a的值
        Persion persion = new Persion();
        Object value = a.get(persion);
        System.out.println(value);
        //设置a的值
        a.set(persion, "张三");
        System.out.println(persion);
        //获取私有变量d的值
        Field d = persionClass.getDeclaredField("d");
        d.setAccessible(true);//暴力反射，忽略访问权限修饰符的安全检查
        Object value2 = d.get(persion);
        System.out.println(value2);


        /**
        * 玩构造函数
        */
        //获取构造函数
        Constructor constructor = persionClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //用获取的构造函数对象来创建对象
        Object person = constructor.newInstance("张三", 23);
        System.out.println(person);

        //获取无参构造函数
        Constructor constructor1 = persionClass.getConstructor();
        System.out.println(constructor1);
        //创建对象
        Object person1 = constructor1.newInstance();
        System.out.println(person1);

        //其实要调用无参构造函数的话，直接用Class对象即可,用它的newInstance方法和用constructor的newInstance一样，但不推荐这么做
        Object o = persionClass.newInstance();
        System.out.println(o);


        /**
         * 玩方法
          */
        //获取指定名称的方法
        Method method1 = persionClass.getMethod("eat");//因为这个eat方法没有参数，所以只传名字即可
        Persion persion1 = new Persion();
        method1.invoke(persion1);

        Method method2 = persionClass.getMethod("eat",String.class);//有参数的
        Persion persion2 = new Persion();
        method2.invoke(persion2, "shit");

        //获取所有public修饰的方法
        Method[] methods = persionClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }

        /**
         * 获取类名
         */
        String className = persionClass.getName();
        System.out.println(className);
    }

}
