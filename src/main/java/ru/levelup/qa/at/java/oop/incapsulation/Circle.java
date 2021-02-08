package ru.levelup.qa.at.java.oop.incapsulation;

public class Circle extends Shape implements Drawable, Movable {

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double diametr() {
        return 2 * radius;
    }

    @Override
    public double square() {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public Circle clone() {
        Circle circle = new Circle();
        circle.setX(this.getX());
        circle.setY(this.getY());
        circle.setRadius(this.radius);
        return circle;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", radius=" + radius +
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
}
