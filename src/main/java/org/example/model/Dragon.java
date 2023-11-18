package org.example.model;

public class Dragon extends Oviparous implements Running, Flying, Swimming {

    public Dragon(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    public void reborn() {
        this.setAge(0);
    }

    @Override
    public void fly() {

    }

    @Override
    public void run() {

    }

    @Override
    public void swim() {

    }
}
