package ru.levelup.qa.at.java.oop.inheretance;

public class Square extends Rectangle {

    public Square(double length) {
        setLength(length);
        setWidth(length);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
