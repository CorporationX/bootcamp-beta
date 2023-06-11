package ru.faang.school.task_1;

import java.util.List;

public class Battlefield {
    private final Hero attacker;
    private final Hero defender;

    public Battlefield(Hero hero1, Hero hero2) {
        this.attacker = hero1;
        this.defender = hero2;
    }

    public Hero battle() {
        List<Creature> army1 = attacker.getArmy();
        List<Creature> army2 = defender.getArmy();

        while (!army1.isEmpty() && army2.isEmpty()) {
            Creature creature1 = army1.get(0);
            Creature creature2 = army2.get(0);

            int damage1 = creature1.getDamage();
            int damage2 = creature2.getDamage();

            int remaining1 = creature1.quantity - attackingFormula(damage2, creature1);
            int remaining2 = creature2.quantity - attackingFormula(damage1, creature2);

            checkDamage(army1, creature1, remaining1);

            checkDamage(army2, creature2, remaining2);
        }

        if (army1.isEmpty()) {
            return defender;
        } else {
            return attacker;
        }
    }

    private static void checkDamage(List<Creature> army1, Creature creature1, int remaining1) {
        if (remaining1 <= 0) {
            army1.remove(0);
        } else {
            creature1.quantity = remaining1;
        }
    }

    private static int attackingFormula(double damage2, Creature creature1) {
        return (int) Math.ceil(damage2 / creature1.defense);
    }
}
