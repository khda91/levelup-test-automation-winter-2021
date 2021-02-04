package ru.levelup.qa.at.java.classloading;

public class ClassInitialization {

    public static final int A = 3;

    public static String name = "ClassInitialization";

    static {
        System.out.println(A);
        System.out.println(name);

        System.out.println("We are in static initialization block");

//        init(); нельзя
//        new ClassInitialization().init(); можно
    }

    {
        System.out.println("non-static block");
    }

    private String nickname = "CI";
    private int a = 12;

    public ClassInitialization() {
        System.out.println(nickname);
        System.out.println(a);

        System.out.println("constructor");
    }

    public void init() {
        System.out.println("method");
    }
}
