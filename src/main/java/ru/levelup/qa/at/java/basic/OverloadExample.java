package ru.levelup.qa.at.java.basic;

public class OverloadExample {

    public static void main(String[] args) {
        add(1, 2);
        add(10., 9.);
        add(4., 9);
    }

    static void add(int a, int b) {
        System.out.println(a + b);
    }

    static void add(double a, double b) {
        System.out.println(a + b);
    }

    static void add(double a, int b) {
        System.out.println(a + b);
    }

    static void createPerson(String name) {
        System.out.println(name + " is created");
    }

    static void createPerson(String name, int age) {
        System.out.println(name + " is created, with ages " + age);
    }

    static void createPerson(int age, String secondName) {
        System.out.println(secondName + " is created, with ages " + age);
    }
}
