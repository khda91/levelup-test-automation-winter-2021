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
    }
}
