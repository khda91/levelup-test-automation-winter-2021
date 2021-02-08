package ru.levelup.qa.at.java.oop.incapsulation;

public interface Movable {

    void moveByX(double x);

    void moveByY(double y);

    default void moveByOffset(double x, double y) {
        System.out.println("Moved somewhere to space");
    }

    static void printSMth(String str) {
        System.out.println(str);
    }
}
