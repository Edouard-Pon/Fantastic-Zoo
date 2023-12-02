package org.example.model.creatures;

import org.example.model.reproduction.Oviparous;
import org.example.model.abilities.Swimming;

public class Kraken extends Oviparous implements Swimming {
    public Kraken(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public void swim() {

    }
}
