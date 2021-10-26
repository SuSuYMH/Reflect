package com.susu.domain;

public class Persion<pubilc> {
    private String name;
    private int age;

    public  String a;
    protected   String b;
    String c;
    private   String d;

    public Persion() {
    }

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void eat() {
        System.out.println("eat......");
    }

    public void eat(String food) {
        System.out.println("eat......"+food);
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
