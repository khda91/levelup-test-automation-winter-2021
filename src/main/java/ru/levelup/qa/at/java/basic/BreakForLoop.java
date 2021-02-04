package ru.levelup.qa.at.java.basic;

public class BreakForLoop {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i > 5) {
                break;
            }
        }

        System.out.println("I'm here");
    }
}
