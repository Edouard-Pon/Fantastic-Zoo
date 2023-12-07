package org.example.model.creatures;

import org.example.model.tasks.Task;
import org.example.model.tasks.creatures.Aging;
import org.example.model.tasks.creatures.Health;
import org.example.model.tasks.creatures.Hunger;
import org.example.model.tasks.creatures.Sleep;

import java.util.ArrayList;

public class Creature {
    private String name;
    private boolean gender;
    private float weight;
    private float height;
    private int age;
    private boolean hunger;//TODO replace with 0-100 scale
    private boolean sleeping;
    private boolean health;//TODO replace with 0-100 scale
    private ArrayList<Task> tasks;
    private ArrayList<Thread> threads;

    public Creature(String name, boolean gender, float weight, float height, int age) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.hunger = false;
        this.sleeping = false;
        this.health = true;
        this.tasks = new ArrayList<>();
        this.threads = new ArrayList<>();
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

    public void startTasks() {
        createTask(new Aging(this));
        createTask(new Health(this));
        createTask(new Hunger(this));
        createTask(new Sleep(this));
        for (Thread thread : threads) thread.start();
    }

    public void createTask(Task task) {
        tasks.add(task);
        threads.add(new Thread(task));
    }

    public void stopTasks() {
        for (Task task : tasks) task.stop();
    }
}
