package ru.levelup.qa.at.java.oop.inheretance;

public class ShapeApp {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(10);
        rectangle.setWidth(20);

        Square square = new Square(5);
        square.setX(0);
        square.setY(1);

        Circle circle = new Circle();
        circle.setRadius(3.6);
        System.out.println("circle diametr -> " + circle.diametr());

        System.out.println("Circle square -> " + circle.square());
        System.out.println("Rectangle square -> " + rectangle.square());
        System.out.println("Square square -> " + square.square());

        System.out.println(circle);

        System.out.println();
        System.out.println();

        Circle circle1 = new Circle();
        circle1.setX(1.0);
        circle1.setY(2.0);
        circle1.setRadius(3.0);

        Circle circle2 = new Circle();
        circle2.setX(1.0);
        circle2.setY(2.0);
        circle2.setRadius(4.0);

        System.out.println("circle 2 -> " + circle2);

        Circle circle3 = circle2;
        circle3.setRadius(5);

        System.out.println("circle 1 == circle 2 -> " + (circle1 == circle2));              // false
        System.out.println("circle 1 equals circle 2 -> " + (circle1.equals(circle2)));     // true
        System.out.println("circle 2 equals circle 3 -> " + (circle2 == circle3));          // true
        System.out.println("circle 2 equals circle 3 -> " + (circle2.equals(circle3)));     // true

        Circle circle4 = circle3;
        circle4.setX(55.758);

        System.out.println("circle 4 -> " + circle4);
        System.out.println("circle 2 -> " + circle2);
        System.out.println("circle 3 -> " + circle3);

        // клонирование
        Circle circleClone = circle4.clone();
        circleClone.setRadius(10);

        System.out.println("circle 2 -> " + circle2);
        System.out.println("circleClone -> " + circleClone);

    }
}
