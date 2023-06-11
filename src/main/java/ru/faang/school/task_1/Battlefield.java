package ru.faang.school.task_1;

import java.util.List;

public class Battlefield {
    private final Hero hero1;
    private final Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        List<Creature> army1 = hero1.getArmy();
        List<Creature> army2 = hero2.getArmy();

        while (!army1.isEmpty() && army2.isEmpty()) {
            Creature creature1 = army1.get(0);
            Creature creature2 = army2.get(0);

            int damage1 = creature1.getDamage();
            int damage2 = creature2.getDamage();

            int remaining1 = creature1.quantity - (int) Math.ceil((double) damage2 / creature1.defense);
            int remaining2 = creature2.quantity - (int) Math.ceil((double) damage1 / creature2.defense);

            if (remaining1 <= 0) {
                army1.remove(0);
            } else {
                creature1.quantity = remaining1;
            }

            if (remaining2 <= 0) {
                army2.remove(0);
            } else {
                creature2.quantity = remaining2;
            }
        }

        if (army1.isEmpty()) {
            return hero2;
        } else {
            return hero1;
        }
    }


}
