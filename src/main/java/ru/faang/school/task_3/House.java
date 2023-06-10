package ru.faang.school.task_3;

import lombok.Getter;

@Getter
public class House {

    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    @Override
    public String toString() {
        return "House of " + name + ", sigil " + sigil;
    }
}
