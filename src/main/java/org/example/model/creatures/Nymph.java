package org.example.model.creatures;

import javafx.application.Platform;
import org.example.model.data.Data;
import org.example.model.reproduction.Viviparous;

public class Nymph extends Viviparous {
    public Nymph(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

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
