package org.example.model.creatures;

import org.example.model.tasks.TaskManager;
import org.example.model.tasks.creatures.*;

public class Creature {
    private String name;
    private boolean gender;
    private float weight;
    private float height;
    private int age;
    private boolean hunger;//TODO replace with 0-100 scale
    private boolean sleeping;
    private boolean health;//TODO replace with 0-100 scale
    private TaskManager taskManager;
    private boolean alive;

    public Creature(String name, boolean gender, float weight, float height, int age) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.hunger = false;
        this.sleeping = false;
        this.health = true;
        this.alive = true;
        this.taskManager = new TaskManager();
        startTasks();
    }

    @Override
    public String toString() {
        return "Name:'" + name + '\'' +
                ", gender:" + gender +
                ", weight:" + weight +
                ", height:" + height +
                ", age:" + age +
                ", hunger:" + hunger +
                ", sleeping:" + sleeping +
                ", health:" + health + "; ";
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

    public boolean isHungry() {
        return hunger;
    }

    public void setHunger(boolean hunger) {
        this.hunger = hunger;
    }

    public void feed() {
        hunger = false;
    }

    public boolean isSleeping() {
        return sleeping;
    }

    public void setSleeping(boolean sleeping) {
        this.sleeping = sleeping;
    }

    public boolean isHealthy() {
        return health;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    public void stopTasks() {
        taskManager.stopTasks();
    }

    public void startTasks() {
        taskManager.startTasks(
                new Aging(this),
                new Health(this),
                new Hunger(this),
                new Sleep(this),
                new Death(this)
        );
    }

    public void clearTasks() {
        taskManager.clearTasks();
    }

    public void heal() {
        health = true;
    }
}
