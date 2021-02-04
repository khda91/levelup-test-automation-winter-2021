package ru.levelup.qa.at.java.staticmodifier;

public class StaticModifierExampleApp {

    public static void main(String[] args) {
        Person vasya = new Person("Vasya", 25);
        vasya.sayHello();

        Person tanya = new Person("Tanya", 23);
        tanya.sayHello();

        tanya.hello = "Ahoj";

        Person stepa = new Person("Stepa", 30);
        stepa.sayHello();
        vasya.sayHello();

        Person.printSomething();
        tanya.printSomething();

        Person.hello = "Привет";
        tanya.sayHello();
        stepa.sayHello();
        vasya.sayHello();
    }
}
