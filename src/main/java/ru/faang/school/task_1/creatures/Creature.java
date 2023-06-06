package ru.faang.school.task_1.creatures;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Creature {

    private String name;
    private int level;
    private int damage;
    private int defense;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int damage, int defense, int speed) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
    }

    public int getTotalDamage() {
        return damage * quantity;
    }

    public int getTotalDefense() {
        return defense * damage;
    }
}
