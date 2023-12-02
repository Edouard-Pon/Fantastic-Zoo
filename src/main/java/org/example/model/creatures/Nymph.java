package org.example.model.creatures;

import org.example.model.reproduction.Viviparous;

public class Nymph extends Viviparous {
    public Nymph(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    public void reborn() {
        this.setAge(0);
    }
}
