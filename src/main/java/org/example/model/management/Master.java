package org.example.model.management;

import org.example.model.creatures.Creature;
import org.example.model.spaces.Enclosure;

import java.util.HashMap;

public class Master {
    private String name;
    private boolean gender;
    private int age;

    public Master(String name, boolean gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public HashMap<String, String> showCharacteristicsOfEnclosure(Enclosure e) {
        return  e.getCharacteristics();
    }

    public void feedCreatures(Enclosure e) {
        e.feedCreatures();
    }

    public void maintainCreatures(Enclosure e) {
        e.maintain();
    }

    public void transferCreatures(Enclosure e1, Enclosure e2) {
        if(e1.getNumberOfCreatures() <= e2.getMaxCreaturesNumber()) {
            e2.addCreatures(e1.getCreaturesList().toArray(new Creature[0]));
            e1.removeCreatures();
        }
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
