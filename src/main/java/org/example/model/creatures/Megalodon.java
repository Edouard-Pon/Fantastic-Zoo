package org.example.model.creatures;

import org.example.model.reproduction.Oviparous;
import org.example.model.abilities.Swimming;

public class Megalodon extends Oviparous implements Swimming {
    public Megalodon(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public void swim() {

    }
}
