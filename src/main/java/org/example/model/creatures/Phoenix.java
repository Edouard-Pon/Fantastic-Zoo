package org.example.model.creatures;

import org.example.model.abilities.Flying;
import org.example.model.reproduction.Oviparous;

public class Phoenix extends Oviparous implements Flying {
    public Phoenix(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    public void reborn() {
        this.setAge(0);
    }

    @Override
    public void fly() {

    }
}
