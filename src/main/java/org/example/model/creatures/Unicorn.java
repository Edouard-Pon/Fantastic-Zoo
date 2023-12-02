package org.example.model.creatures;

import org.example.model.abilities.Running;
import org.example.model.reproduction.Viviparous;

public class Unicorn extends Viviparous implements Running {
    public Unicorn(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public void run() {

    }
}
