package org.example.model;

public class Oviparous extends Creature{
    private boolean eggFertile;
    private int incubationPeriod;

    public Oviparous(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    public void layAnEgg() {
        if (eggFertile) {
            //lay an egg that will produce creature
        } else {
            //lay an egg that will NOT produce creature
        }
    }
}
