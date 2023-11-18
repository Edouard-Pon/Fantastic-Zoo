package org.example.model;

public class Unicorn extends Viviparous implements Running {
    public Unicorn(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public void run() {

    }
}
