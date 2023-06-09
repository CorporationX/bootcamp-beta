package ru.faang.school.hashmap.task_1;

import java.util.HashMap;

public class Main {
    private static final HashMap<String, House> STRING_HOUSE_HASH_MAP = new HashMap<>();

    public static void main(String[] args) {
        addHouses();
        printAllHouses();
        addNewHouse("Targarien", "Drakon");
        printAllHouses();
        removeHouse("Lannister");
        printAllHouses();
        findHouse("Stark");
    }

    private static void addHouses() {
        addNewHouse("Some house", "Some sigil");
        addNewHouse("Some house1", "Some sigil1");
        addNewHouse("Some house2", "Some sigil2");

    }

    private static void addNewHouse(String name, String sigil) {
        House newHouse = new House(name, sigil);
        STRING_HOUSE_HASH_MAP.put(newHouse.getName(), newHouse);
        System.out.println("New House was added: " + newHouse.getName());
    }

    private static void removeHouse(String name) {
        House removedHouse = STRING_HOUSE_HASH_MAP.remove(name);
        if (removedHouse != null) {
            System.out.println("House " + removedHouse.getName() + " removed");
        }
        else {
            System.out.println("House " + name + " not found");
        }
    }

    private static void findHouse(String name) {
        House house = STRING_HOUSE_HASH_MAP.get(name);
        if (house != null) {
            System.out.println("Info about house " + name + ":");
            System.out.println("Sigil: " + house.getSigil());
        } else {
            System.out.println("House " + name + " not found");
        }
    }

    private static void printAllHouses() {
        System.out.println("List of all houses and their sigils:");
        for (var entry : STRING_HOUSE_HASH_MAP.entrySet())
            System.out.println("House: " + entry.getKey() + ", Sigil: " + entry.getValue().getSigil());

        System.out.println();
    }
}