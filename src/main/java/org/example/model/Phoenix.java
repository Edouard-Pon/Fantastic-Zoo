package org.example.model;

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
