package ru.faang.school.hashmap.task_1;


import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, Home> homes = new HashMap<>();

    public static void main(String[] args) {
        addHome("Lan", "altai");
        addHome("Bas", "USA");
        addHome("Wint", "IRLAN");
        addHome("Rilo", "USA");

        search("Lan");
        allHome();
        deleteHome("Bas");
        allHome();
    }

    private static void addHome(String home, String sigil) {
        homes.put(home, new Home(home, sigil));
    }

    private static void deleteHome(String home) {
        homes.remove(home);
    }

    private static void allHome() {
        homes.forEach((key, value) -> System.out.println(value.toString()));
    }

    private static void search(String home) {
        System.out.println(homes.get(home));
    }
}