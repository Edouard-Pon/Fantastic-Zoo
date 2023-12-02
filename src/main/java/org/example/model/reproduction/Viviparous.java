package org.example.model.reproduction;

import org.example.model.creatures.Creature;

public class Viviparous extends Creature {
    private boolean gestation;
    private int gestationPeriod;

    public Viviparous(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    public void giveBirth() {
        if (gestation) {
            gestation = false;
        }
    }

    public boolean isGestation() {
        return gestation;
    }

    public void setGestation(boolean gestation) {
        this.gestation = gestation;
    }

    public int getGestationPeriod() {
        return gestationPeriod;
    }

    public void setGestationPeriod(int gestationPeriod) {
        this.gestationPeriod = gestationPeriod;
    }
}
