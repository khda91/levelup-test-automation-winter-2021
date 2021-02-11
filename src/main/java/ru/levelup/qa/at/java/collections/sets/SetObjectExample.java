package ru.levelup.qa.at.java.collections.sets;

import java.util.HashSet;
import java.util.Set;

public class SetObjectExample {

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();

        Person вася = new Person("Вася", "Пупкин", 24);

        set.add(вася);
        set.add(new Person("Петя", "Васечкин", 30));
        set.add(new Person("Света", "Голикова", 18));
        set.add(new Person("Надя", "Петрова", 21));
        set.add(new Person("Надя", "Петрова", 21));
        set.add(new Person("Надя", "Петрова", 21));
        set.add(new Person("Надя", "Петрова", 21));
        set.add(new Person("Надя", "Петрова", 21));
        set.add(new Person("Вася", "Пупкин", 24));
        set.add(new Person("Вася", "Пупкин", 24));
        set.add(new Person("Вася", "Пупкин", 24));
        set.add(new Person("Вася", "Пупкин", 24));
        set.add(new Person("Петя", "Васечкин", 30));
        set.add(new Person("Лида", "Смирнова", 30));
        set.add(new Person("Лида", "Смирнова", 30));
        set.add(new Person("Лида", "Смирнова", 30));
        set.add(new Person("Лида", "Смирнова", 30));
        set.add(new Person("Лида", "Смирнова", 30));
        set.add(вася);

        System.out.println("================");
        set.forEach(System.out::println);
        System.out.println("================");

    }
}
