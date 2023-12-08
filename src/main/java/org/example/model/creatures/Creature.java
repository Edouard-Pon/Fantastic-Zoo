package org.example.model.creatures;

import org.example.model.tasks.TaskManager;
import org.example.model.tasks.creatures.*;

/**
 * Creature class is a base class for all creatures in the simulation.
 */
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

    /**
     * Constructor for Creature class.
     * @param name
     * @param gender
     * @param weight
     * @param height
     * @param age
     */
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

    /**
     * toString method for Creature class.
     * @return String
     */
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

    /**
     * Method for creature to eat.
     */
    public void eat() {
        if (!sleeping && hunger) {
            hunger = false;
        }
    }

    /**
     * Method for creature to sleep.
     */
    public void sleep() {
        if (!sleeping) {
            sleeping = true;
        }
    }

    /**
     * Method for creature to age.
     */
    public void age() {
        setAge(1 + age);
    }


    /**
     * Method to get name of the creature.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set name of the creature.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the gender of the creature.
     * @return gender
     */
    public boolean isGender() {
        return gender;
    }

    /**
     * Method to set the gender of the creature.
     * @param gender
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    /**
     * Method to get the weight of the creature.
     * @return weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Method to set the weight of the creature.
     * @param weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Method to get the height of the creature.
     * @return height
     */
    public float getHeight() {
        return height;
    }

    /**
     * Method to set the height of the creature.
     * @param height
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Method to get the age of the creature.
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Method to set the age of the creature.
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Method to check if the creature is hungry.
     * @return hunger
     */
    public boolean isHungry() {
        return hunger;
    }

    /**
     * Method to set the hunger of the creature.
     * @param hunger
     */
    public void setHunger(boolean hunger) {
        this.hunger = hunger;
    }

    /**
     * Method to feed the creature.
     */
    public void feed() {
        hunger = false;
    }

    /**
     * Method to check if the creature is sleeping.
     * @return sleeping
     */
    public boolean isSleeping() {
        return sleeping;
    }

    /**
     * Method to set the sleeping parameter of the creature.
     * @param sleeping
     */
    public void setSleeping(boolean sleeping) {
        this.sleeping = sleeping;
    }

    /**
     * Method to check if the creature is healthy.
     * @return health
     */
    public boolean isHealthy() {
        return health;
    }

    /**
     * Method to check if the creature is alive.
     * @return alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Method to set the alive parameter of the creature.
     * @param alive
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Method to set the health parameter of the creature.
     * @param health
     */
    public void setHealth(boolean health) {
        this.health = health;
    }

    /**
     * Method to stop the tasks of the creature.
     */
    public void stopTasks() {
        taskManager.stopTasks();
    }

    /**
     * Method to start the tasks of the creature.
     */
    public void startTasks() {
        taskManager.startTasks(
                new Aging(this),
                new Health(this),
                new Hunger(this),
                new Sleep(this),
                new Death(this),
                new Abilities(this)
        );
    }

    /**
     * Method to clear the tasks of the creature.
     */
    public void clearTasks() {
        taskManager.clearTasks();
    }

    /**
     * Method to heal the creature.
     */
    public void heal() {
        health = true;
    }
}
