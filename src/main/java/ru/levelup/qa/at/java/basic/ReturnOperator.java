package ru.levelup.qa.at.java.basic;

public class ReturnOperator {

    public static void main(String[] args) {
        breakMethod();
        returnMethod();
        breakMethod();

        if (1 > 2) {
            return;
        }

        System.out.println("I'm here");
    }

    static void breakMethod() {
        for (int i = 0; i < 10; i++) {
            if (i > 5) {
                break;
            }
            System.out.println(i);
        }

        System.out.println("break is here");
    }

    static void returnMethod() {
        for (int i = 0; i < 10; i++) {
            if (i > 5) {
                return;
            }
            System.out.println(i);
        }
        System.out.println("return is here");
    }
}
