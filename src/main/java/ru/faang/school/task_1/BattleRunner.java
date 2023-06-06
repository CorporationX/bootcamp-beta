package ru.faang.school.task_1;

import ru.faang.school.task_1.creatures.*;

public class BattleRunner {

    public static void main(String[] args) {
        Creature pikeman = new Pikeman();
        Creature swordsman = new Swordsman();
        Creature griffin = new Griffin();
        Creature angel = new Angel();
        Creature undeadPikeman = new Pikeman();
        Creature undeadSwordsman = new Swordsman();
        Creature undeadGriffin = new Griffin();

        Hero attacker = new Hero("King Leoric", "Undead");
        attacker.addCreature(undeadPikeman,300);
        attacker.addCreature(undeadSwordsman,70);
        attacker.addCreature(undeadGriffin,80);

        Hero defender = new Hero("Val", "Elf");
        defender.addCreature(pikeman,150);
        defender.addCreature(swordsman,50);
        defender.addCreature(griffin,40);
        defender.addCreature(angel,2);

        Battlefield battlefield = new Battlefield(attacker,defender);
        Hero winner = battlefield.battle();
        System.out.println("Hero " + winner.getName() + " won the battle!");
    }
}
