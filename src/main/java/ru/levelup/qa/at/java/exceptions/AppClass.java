package ru.levelup.qa.at.java.exceptions;

public class AppClass {

    public static void main(String[] args) {
        String str = "";

//        if (str.isEmpty()) {
//            throw new MyCustomException("Empty String is not allowed here");
//        }

        try {
            method1("");
            method2("");
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            method1("");
            method2("");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
            System.out.println("hdsvbasdhvhdbavbaewu");
        }
    }

    static void method1(String str) throws IllegalArgumentException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Empty String is not allowed here");
        }

        System.out.println(str);
    }

    static void method2(String str) throws IllegalAccessException {
        if (!str.isEmpty()) {
            throw new IllegalAccessException("Not Empty String is not allowed here");
        }

        System.out.println(str);
    }
}
