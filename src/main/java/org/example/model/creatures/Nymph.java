package org.example.model.creatures;

import javafx.application.Platform;
import org.example.model.data.Data;
import org.example.model.reproduction.Viviparous;

public class Nymph extends Viviparous {

    /**
     * Constructor of Nymph
     * @param name
     * @param gender
     * @param weight
     * @param height
     * @param age
     */
    public Nymph(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    /**
     * Reborn the nymph
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
}
