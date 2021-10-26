package com.susu.annotation;


import java.lang.annotation.*;

@Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented//这样的话，加了MyAnno3的注解的东西，在api文档中也会出现@MyAnno3的字样
@Inherited//表示被描述的注解会不会自动被子类继承
public @interface MyAnno3 {
}
