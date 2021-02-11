package ru.levelup.qa.at.java.collections.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("mama");
        set.add("rama");
        set.add("nyla");
        set.add("papa");
        set.add("mama");
        set.add("apple");

        System.out.println("=====");
        System.out.println(set);
        System.out.println("=====");
        System.out.println();

        System.out.println("=====");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("rama".equals(next)) {
                break;
            }
            System.out.println(next);
        }
        System.out.println("=====");
        System.out.println();

        System.out.println("=====");
        System.out.println(iterator);
        System.out.println("=====");
        System.out.println();

        System.out.println("=====");
        String string = "";
        iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("papa".equals(next)) {
                string = next;
            }
        }
        System.out.println(string);
        System.out.println("=====");
        System.out.println();


        set.remove("rama");
        System.out.println("=====");
        System.out.println(set);
        System.out.println("=====");
        System.out.println();
    }

}
