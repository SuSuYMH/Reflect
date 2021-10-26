package com.susu.reflect;

import com.susu.domain.Persion;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取类对象的三种方式：
        //1.Class。forName（"全类名"）
        Class cls1 = Class.forName("com.susu.domain.Persion");
        System.out.println(cls1);

        //2.类名.class
        Class cls2 = Persion.class;
        System.out.println(cls2);

        //3.对象.getClass()
        Persion persion = new Persion();
        Class cls3 = persion.getClass();
        System.out.println(cls3);

        //验证他们三个是否是同一个对象 ==比较比较的是对象的内存地址，地址值相同的话证明他们是同一个对象
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
    }
}
