package ru.faang.school.task_3;

public class HouseManager {

    public static void main(String[] args) {
        House lannister = new House("Lannister", "Lion");
        House stark = new House("Stark", "Dire-wolf");
        House baratheon = new House("Baratheon", "Deer");

        HouseDirectory houseDirectory = new HouseDirectory();
        houseDirectory.addHouse(lannister);
        houseDirectory.addHouse(stark);
        houseDirectory.addHouse(baratheon);
        houseDirectory.printListOfHouses();

        houseDirectory.removeHouseByName("Lannister");
        System.out.println();
        houseDirectory.printListOfHouses();
        System.out.println();
        System.out.println(houseDirectory.getSigilByHouseName("Baratheon"));
    }
}
