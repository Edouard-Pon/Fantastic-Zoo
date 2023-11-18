package org.example.model;

public class Creature {
    private String name;
    private boolean gender;
    private float weight;
    private float height;
    private int age;
    private boolean hunger;
    private boolean sleeping;
    private boolean health;

    public Creature(String name, boolean gender, float weight, float height, int age) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public void eat() {
        if (!sleeping && hunger) {
            hunger = false;
        }
    }

    public void makeSound() {
        System.out.println("roar");
    }

    public void treat() {
        if (!health) {
            health = true;
        }
    }

    public void sleep() {
        if (!sleeping) {
            sleeping = true;
        }
    }

    public void wakeUp() {
        if (sleeping) {
            sleeping = false;
        }
    }

    public void age() {
        setAge(1 + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHunger() {
        return hunger;
    }

    public void setHunger(boolean hunger) {
        this.hunger = hunger;
    }

    public boolean isSleeping() {
        return sleeping;
    }

    public void setSleeping(boolean sleeping) {
        this.sleeping = sleeping;
    }

    public boolean isHealth() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }
}
