package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }
}
