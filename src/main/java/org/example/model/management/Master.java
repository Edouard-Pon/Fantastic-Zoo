package org.example.model.management;

import org.example.model.creatures.Creature;
import org.example.model.spaces.Enclosure;

import java.util.HashMap;

public class Master {
    private String name;
    private boolean gender;
    private int age;

    /**
     * Constructor
     * @param name
     * @param gender
     * @param age
     */
    public Master(String name, boolean gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    /**
     * Show characteristics of an enclosure
     * @param e
     * @return
     */
    public HashMap<String, String> showCharacteristicsOfEnclosure(Enclosure e) {
        return  e.getCharacteristics();
    }

    /**
     * Feed creatures in an enclosure
     * @param e
     */
    public void feedCreatures(Enclosure e) {
        e.feedCreatures();
    }

    /**
     * Maintain creatures in an enclosure
     * @param e
     */
    public void maintainCreatures(Enclosure e) {
        e.maintain();
    }

    /**
     * Transfer creatures from one enclosure to another
     * @param e1
     * @param e2
     */
    public void transferCreatures(Enclosure e1, Enclosure e2) {
        if(e1.getNumberOfCreatures() <= e2.getMaxCreaturesNumber()) {
            e2.addCreatures(e1.getCreaturesList().toArray(new Creature[0]));
            e1.removeCreatures();
        }
    }

    /**
     * Get name of master
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get gender of master
     * @return gender
     */
    public boolean isGender() {
        return gender;
    }

    /**
     * Get age of master
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set age of master
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
