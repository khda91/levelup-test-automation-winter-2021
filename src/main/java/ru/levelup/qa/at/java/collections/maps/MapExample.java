package ru.levelup.qa.at.java.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("Вася", "Лена");
        map.put("Петя", "Света");
        map.put("Оля", "Максим");
        map.put("Вася", "Нина");
        map.put("Марина", "Серёжа");
        map.put("Света", "Никита");
        map.put("Вася", "Ника");
        map.put("Коля", "Ника");
//        map.put("Элеанора", "Виктор");

        System.out.println("========");
        System.out.println(map);
        System.out.println("========");
        System.out.println();

        System.out.println("========");
        System.out.println(map.get("Света"));
        System.out.println("========");
        System.out.println();

        System.out.println("========");
        System.out.println(map.getOrDefault("Элеанора", "Михаил"));
        System.out.println("========");
        System.out.println();

        System.out.println("========");
        System.out.println(map);
        System.out.println("========");
        System.out.println();

        if (!map.containsKey("Элеанора")) {
            map.put("Элеанора", "Виктор");
        }

        map.putIfAbsent("Катя", "Валера");

        System.out.println("========");
        System.out.println(map);
        System.out.println("========");
        System.out.println();

        System.out.println("========");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " || " + entry.getValue());
        }
        System.out.println("========");
        System.out.println();

//        map.keySet() - уникальные ключи
    }

}
