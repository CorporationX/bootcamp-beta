package ru.faang.school.task_1;

import java.util.Objects;

public abstract class Creature {
    protected String name;
    protected int level;
    protected int  attack;
    protected int defense;
    protected int speed;
    protected int quantity;

    public Creature(String name, int level, int attack, int defense, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.quantity = quantity;
    }

    public  int getDamage() {
        return attack * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return level == creature.level && attack == creature.attack && defense == creature.defense && speed == creature.speed && quantity == creature.quantity && Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, attack, defense, speed, quantity);
    }
}
