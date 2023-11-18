package org.example.model;

public class Lycanthrope extends Viviparous implements Running {
    public Lycanthrope(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public void run() {
        System.out.println("Lycanthrope is running");
    }
}
