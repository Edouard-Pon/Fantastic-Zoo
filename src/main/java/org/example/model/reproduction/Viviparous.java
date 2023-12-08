package org.example.model.reproduction;

import org.example.model.creatures.Creature;

public class Viviparous extends Creature {
    private boolean gestation;
    private int gestationPeriod;

    /**
     * Constructor
     * @param name
     * @param gender
     * @param weight
     * @param height
     * @param age
     */
    public Viviparous(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    /**
     * Give birth
     */
    public void giveBirth() {
        if (gestation) {
            gestation = false;
        }
    }

    /**
     * Check if the creature is gestating
     * @return gestation
     */
    public boolean isGestation() {
        return gestation;
    }

    /**
     * Set the gestation
     * @param gestation
     */
    public void setGestation(boolean gestation) {
        this.gestation = gestation;
    }

    /**
     * Get the gestation period
     * @return gestationPeriod
     */
    public int getGestationPeriod() {
        return gestationPeriod;
    }

    /**
     * Set the gestation period
     * @param gestationPeriod
     */
    public void setGestationPeriod(int gestationPeriod) {
        this.gestationPeriod = gestationPeriod;
    }
}
