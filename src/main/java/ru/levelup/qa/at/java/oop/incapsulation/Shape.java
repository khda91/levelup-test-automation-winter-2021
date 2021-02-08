package ru.levelup.qa.at.java.oop.incapsulation;

public abstract class Shape {

    private double x;
    private double y;

    public abstract double square();

    public void perimetr() {
        System.out.println("Perimeter");
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static void printSMth(String str) {
        System.out.println(Shape.class.getCanonicalName() + " -> " + str);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shape shape = (Shape) o;

        if (Double.compare(shape.x, x) != 0) return false;
        return Double.compare(shape.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Shape shape = (Shape) o;
//        return Double.compare(shape.x, x) == 0 && Double.compare(shape.y, y) == 0;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y);
//    }

    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
