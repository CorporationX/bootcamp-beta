package ru.faang.school.task_1;

import lombok.Getter;
import ru.faang.school.task_1.creatures.Creature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero {

    private @Getter String name;
    private String faction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;

    public Hero(String name, String faction) {
        this.name = name;
        this.faction = faction;
        this.experience = 0;
        this.level = 1;
        this.army = new HashMap<>();
    }

    void addCreature(Creature creature, int quantity) {
        army.put(creature, army.getOrDefault(creature, 0) + quantity);
        creature.setQuantity(creature.getQuantity() + quantity);
    }

    boolean removeCreature(Creature creature, int quantity) {
        if (!army.containsKey(creature)) {
            return false;
        }
        int currentQuantity = army.getOrDefault(creature, 0);

        if (currentQuantity <= quantity) {
            army.remove(creature);
            creature.setQuantity(0);
        } else {
            army.put(creature, currentQuantity - quantity);
            creature.setQuantity(creature.getQuantity() - quantity);
        }

        return true;
    }

    List<Creature> getArmy() {
        List<Creature> armyList = new ArrayList<>();

        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            armyList.add(entry.getKey());
        }

        return armyList;
    }
}
