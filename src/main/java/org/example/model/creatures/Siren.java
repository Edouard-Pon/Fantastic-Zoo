package org.example.model.creatures;

import org.example.model.abilities.Swimming;
import org.example.model.reproduction.Viviparous;

public class Siren extends Viviparous implements Swimming {
    public Siren(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public void swim() {

    }
}
