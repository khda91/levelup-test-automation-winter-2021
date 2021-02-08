package ru.levelup.qa.at.java.oop.incapsulation;

public class ShapeApp {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(10);
        rectangle.setWidth(20);

        Circle circle = new Circle();
        circle.setRadius(3.6);

        rectangle.draw();
        circle.draw();

        System.out.println();
        System.out.println(String.format("Circle X: %s || Y: %s", circle.getX(), circle.getY()));
        System.out.println(String.format("Rectangle X: %s || Y: %s", rectangle.getX(), rectangle.getY()));

        circle.moveByOffset(10, 10);
        rectangle.moveByOffset(1, 1);

        System.out.println();
        System.out.println(String.format("Circle X: %s || Y: %s", circle.getX(), circle.getY()));
        System.out.println(String.format("Rectangle X: %s || Y: %s", rectangle.getX(), rectangle.getY()));

        Movable.printSMth("jdjjdjhsyerywnsd");
        Rectangle.printSMth("jdsbvuaviewpovbewbvewnviewnlovew");
        Shape.printSMth("sdfghjkl");
    }
}
