package ru.faang.school.task_3;

import java.util.LinkedHashMap;
import java.util.Map;

public class HouseDirectory {

    private Map<String, House> houses;

    public HouseDirectory() {
        houses = new LinkedHashMap<>();
    }

    public void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public void removeHouseByName(String houseName) {
        houses.remove(houseName);
    }

    public String getSigilByHouseName(String houseName) {
       House house = houses.get(houseName);
       return house.getSigil();
    }

    public void printListOfHouses() {
        houses.forEach((key, value) -> System.out.println(value));
    }

}
