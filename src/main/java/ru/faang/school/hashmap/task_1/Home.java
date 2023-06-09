package ru.faang.school.hashmap.task_1;

public class Home {
    private String name;
    private String sigil;

    public Home(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSigil() {
        return sigil;
    }

    public void setSigil(String sigil) {
        this.sigil = sigil;
    }

    @Override
    public String toString() {
        return "Дом: " + name + " Герб: " + sigil;
    }
}
