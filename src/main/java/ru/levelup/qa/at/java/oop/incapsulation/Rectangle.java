package ru.levelup.qa.at.java.oop.incapsulation;

public class Rectangle extends Shape implements Drawable, Movable {

    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double square() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    @Override
    public void draw() {
        System.out.println("draw -> " + this.getClass().getName());
    }

    @Override
    public void moveByX(double x) {
        this.setX(this.getX() + x);
    }

    @Override
    public void moveByY(double y) {
        this.setY(this.getY() + y);
    }

    @Override
    public void moveByOffset(double x, double y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

//    public static void printSMth(String str) {
//        System.out.println(Rectangle.class.getCanonicalName() + " ---> " + str);
//    }
}
