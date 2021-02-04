package ru.levelup.qa.at.java.basic;

public class ContinueForLoop {

    public static void main(String[] args) {

        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }

        System.out.println("I'm here");
    }
}
