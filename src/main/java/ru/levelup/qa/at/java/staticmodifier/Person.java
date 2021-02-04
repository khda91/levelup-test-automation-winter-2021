package ru.levelup.qa.at.java.staticmodifier;

public class Person {

    public static final double PI = 3.1415;

    static String hello = "Hello";

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println(hello + "! My name is " + name);
    }

    static void printSomething() {
        System.out.println("Print something");
    }
}
