package ru.levelup.qa.at.java.classloading;

public class ClassInitializationApp {

    public static void main(String[] args) {
        ClassInitialization ci = new ClassInitialization();
        ci.init();

        System.out.println();
        ClassInitialization ci1 = new ClassInitialization();
        ci1.init();
    }
}
