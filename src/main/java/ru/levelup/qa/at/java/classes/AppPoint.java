package ru.levelup.qa.at.java.classes;

public class AppPoint {

    public static void main(String[] args) {
        Point point1 = new Point(35.3, 89.25);
        System.out.println(point1);

        Point point2 = new Point();
        System.out.println(point2);

        point2.setX(1.09);
        point2.setY(3.0008);
        System.out.println(point2);
    }
}
