package com.susu.annotation;

public @interface MyAno {
    //这些都是成员函数，因为是接口，可以省略默认的public abstract
     int show();
     String show2();
     Student stu();
     MyAnno2 anno2();
     String[] strs();
}
