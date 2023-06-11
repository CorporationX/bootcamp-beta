package ru.faang.school.task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero {
    private final String name;
    private final String faction;
    private final int experience;
    private final int level;
    private final Map<Creature,Integer> army;

    public Hero(String name, String faction) {
        this.name = name;
        this.faction = faction;
        this.experience = 0;
        this.level = 1;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        army.put(creature,quantity);
    }


    public List<Creature> getArmy() {
        ArrayList<Creature> armyList = new ArrayList<>();
        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            Creature creature = entry.getKey();
            int quantity = entry.getValue();

            for (int i = 0; i < quantity; i++) {
                armyList.add(creature);
            }
        }

        return armyList;
    }

    // Getter for printing winner
    public String getName() {
        return name;
    }
}
