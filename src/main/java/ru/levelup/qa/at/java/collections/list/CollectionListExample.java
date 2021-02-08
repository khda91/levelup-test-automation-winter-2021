package ru.levelup.qa.at.java.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionListExample {

    public static void main(String[] args) {

        iniList();

    }

    static void iniList() {
        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            intList.add(i);
        }

        System.out.println("Int list size -> " + intList.size());
        printList(intList);

        intList.add(66);
        intList.add(59);
        System.out.println("Int list size -> " + intList.size());
        intList.add(2, 99);
        intList.add(10, 100);
        System.out.println("Int list size -> " + intList.size());
        intList.set(23, 555);
        intList.set(17, 777);
        System.out.println("Int list size -> " + intList.size());
        printList(intList);

        for (int i = 0; i < intList.size(); i++) {
            intList.set(i, intList.get(i) * 2);
        }

        printList(intList);

        Iterator<Integer> iterator = intList.iterator();
        int max = 0;
        while (iterator.hasNext()) {
            int tmp = iterator.next();
            if (max < tmp) {
                max = tmp;
            }
        }
        System.out.println("Max - > " + max);

        System.out.println(intList.stream().map(Object::toString).collect(Collectors.joining(" :||: ")));
        printListWithoutLastSymbol(intList);

        int asInt = intList.stream().mapToInt(i -> i * 3).max().getAsInt();
        System.out.println("Max - > " + asInt);
    }

    static void printListWithoutLastSymbol(List<Integer> list) {
        System.out.println("======");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + ", ");
            }
        }
        System.out.println();
        System.out.println("======");
    }

    static void printList(List<Integer> list) {
        System.out.println("======");
        for (Integer integer : list) {
            System.out.print(integer + ", ");
        }
        System.out.println();
        System.out.println("======");
    }
}
