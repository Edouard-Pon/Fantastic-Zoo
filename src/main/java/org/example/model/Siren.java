package org.example.model;

public class Siren extends Viviparous implements Swimming {
    public Siren(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public void swim() {

    }
}
