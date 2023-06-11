package ru.faang.school.task_1;

public class Main {
    public static void main(String[] args) {
        Pikeman pikeman1 = new Pikeman(100);
        Griffin griffin1 = new Griffin(50);
        Swordman swordsman1 = new Swordman(30);

        Pikeman pikeman2 = new Pikeman(80);
        Griffin griffin2 = new Griffin(70);
        Angel angel2 = new Angel(20);

        Hero hero1 = new Hero("Hero 1", "Castle");
        Hero hero2 = new Hero("Hero 2", "Inferno");

        hero1.addCreature(pikeman1, pikeman1.quantity);
        hero1.addCreature(griffin1, griffin1.quantity);
        hero1.addCreature(swordsman1, swordsman1.quantity);


        hero2.addCreature(pikeman2, pikeman2.quantity);
        hero2.addCreature(griffin2, griffin2.quantity);
        hero2.addCreature(angel2, angel2.quantity);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();
        System.out.println("Winner: " + winner.getName());
    }
}
