package ru.faang.school.hashmap.task_1;

import java.util.HashMap;

public class Main {
    private static final HashMap<String, House> houses = new HashMap<>();

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
        House stark = new House("Stark", "Volf");
        houses.put(stark.getName(), stark);

        House lannister = new House("Lannister", "Lion");
        houses.put(lannister.getName(), lannister);

        House baratheon = new House("Baratheon", "Elephant");
        houses.put(baratheon.getName(), baratheon);
    }

    private static void addNewHouse(String name, String sigil) {
        House newHouse = new House(name, sigil);
        houses.put(newHouse.getName(), newHouse);
        System.out.println("New House was added: " + newHouse.getName());
    }

    private static void removeHouse(String name) {
        House removedHouse = houses.remove(name);
        if (removedHouse != null)
            System.out.println("House " + removedHouse.getName() + " removed");
        else
            System.out.println("House " + name + " not found");
    }

    private static void findHouse(String name) {
        House house = houses.get(name);
        if (house != null) {
            System.out.println("Info about house " + name + ":");
            System.out.println("Sigil: " + house.getSigil());
        } else {
            System.out.println("House " + name + " not found");
        }
    }

    private static void printAllHouses() {
        System.out.println("List of all houses and their sigils:");
        for (var entry : houses.entrySet())
            System.out.println("House: " + entry.getKey() + ", Sigil: " + entry.getValue().getSigil());

        System.out.println();
    }
}