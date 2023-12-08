package org.example.model.creatures;

import javafx.application.Platform;
import org.example.model.abilities.Flying;
import org.example.model.data.Data;
import org.example.model.reproduction.Oviparous;

public class Phoenix extends Oviparous implements Flying {

    /**
     * Constructor of Phoenix
     * @param name
     * @param gender
     * @param weight
     * @param height
     * @param age
     */
    public Phoenix(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    /**
     * Reborn the Phoenix
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
     * Phoenix is flying
     */
    @Override
    public void fly() {
        Platform.runLater(() -> Data.getInstance().addLogMessage(this.getName() + " is flying!"));
    }
}
