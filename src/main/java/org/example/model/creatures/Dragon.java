package org.example.model.creatures;

import javafx.application.Platform;
import org.example.model.abilities.Flying;
import org.example.model.data.Data;
import org.example.model.reproduction.Oviparous;
import org.example.model.abilities.Running;
import org.example.model.abilities.Swimming;

public class Dragon extends Oviparous implements Running, Flying, Swimming {

    /**
     * Constructor of Dragon
     * @param name
     * @param gender
     * @param weight
     * @param height
     * @param age
     */
    public Dragon(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    /**
     * Reborn the dragon
     */
    public void reborn() {
        this.setAge(0);
        this.setAlive(true);
        this.setHealth(true);
        this.setHunger(true);
        this.setSleeping(false);
        this.clearTasks();
        this.startTasks();
        Platform.runLater(() -> Data.getInstance().addLogMessage(this.getName() + " has reborn!"));
    }

    /**
     * Dragon is flying
     */
    @Override
    public void fly() {
        Platform.runLater(() -> Data.getInstance().addLogMessage(this.getName() + " is flying!"));
    }

    /**
     * Dragon is running
     */
    @Override
    public void run() {
        Platform.runLater(() -> Data.getInstance().addLogMessage(this.getName() + " is running!"));
    }

    /**
     * Dragon is swimming
     */
    @Override
    public void swim() {
        Platform.runLater(() -> Data.getInstance().addLogMessage(this.getName() + " is swimming!"));
    }
}
