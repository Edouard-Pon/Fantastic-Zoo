package org.example.model.reproduction;

import org.example.model.creatures.Creature;

public class Oviparous extends Creature {
    private boolean eggFertile;
    private int incubationPeriod;

    /**
     * Constructor for Oviparous
     * @param name
     * @param gender
     * @param weight
     * @param height
     * @param age
     */
    public Oviparous(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    /**
     * Lay an egg WIP
     */
    public void layAnEgg() {
        if (eggFertile) {
            //lay an egg that will produce creature
        } else {
            //lay an egg that will NOT produce creature
        }
    }
}
