package ru.faang.school.task_1;

import ru.faang.school.task_1.creatures.Creature;

import java.util.List;
import java.util.Random;

public class Battlefield {

    private Hero attackingHero;
    private Hero defendingHero;
    private Random random;

    public Battlefield(Hero attackingHero, Hero defendingHero) {
        this.attackingHero = attackingHero;
        this.defendingHero = defendingHero;
        this.random = new Random();
    }

    public Hero battle() {
        while (true) {
            List<Creature> attackingArmy = attackingHero.getArmy();
            List<Creature> defendingArmy = defendingHero.getArmy();

            if (attackingArmy.isEmpty()) {
                return defendingHero;
            } else if (defendingArmy.isEmpty()) {
                return attackingHero;
            }
            Creature attackerCreature = getRandomCreature(attackingArmy);
            Creature defenderCreature = getRandomCreature(defendingArmy);

            attack(attackingHero, attackerCreature, defendingHero, defenderCreature);
            counterAttack();
        }
    }

    private Creature getRandomCreature(List<Creature> army) {
        int index = random.nextInt(army.size());

        return army.get(index);
    }

    private void counterAttack() {
        List<Creature> attackingArmy = attackingHero.getArmy();
        List<Creature> defendingArmy = defendingHero.getArmy();

        if (attackingArmy.isEmpty() || defendingArmy.isEmpty()) {
            return;
        } else {
            Creature attackerCreature = getRandomCreature(attackingArmy);
            Creature defenderCreature = getRandomCreature(defendingArmy);
            attack(defendingHero, defenderCreature, attackingHero, attackerCreature);
        }
    }

    private void attack(Hero attacker, Creature attackerCreature, Hero defender, Creature defenderCreature) {
        int creaturesKilled = 0;

        if (attackerCreature.getTotalDamage() >= defenderCreature.getTotalDefense()) {
            defender.removeCreature(defenderCreature, defenderCreature.getQuantity());
        } else {
            creaturesKilled = attackerCreature.getTotalDamage() / defenderCreature.getDefense();
            defender.removeCreature(defenderCreature, creaturesKilled);
            if (defenderCreature.getSpeed() > attackerCreature.getSpeed()) {
                if (defenderCreature.getTotalDamage() >= attackerCreature.getTotalDefense()) {
                    attacker.removeCreature(attackerCreature, attackerCreature.getQuantity());
                } else {
                    creaturesKilled = defenderCreature.getTotalDamage() / attackerCreature.getDefense();
                    attacker.removeCreature(attackerCreature, creaturesKilled);
                }
            }
        }
    }
}
