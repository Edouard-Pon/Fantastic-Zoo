package org.example.model.creatures;

import javafx.application.Platform;
import org.example.model.abilities.Running;
import org.example.model.data.Data;
import org.example.model.reproduction.Viviparous;

public class Unicorn extends Viviparous implements Running {

    /**
     * Constructor of Unicorn
     * @param name
     * @param gender
     * @param weight
     * @param height
     * @param age
     */
    public Unicorn(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    /**
     * Unicorn is running
     */
    @Override
    public void run() {
        Platform.runLater(() -> Data.getInstance().addLogMessage(getName() + " is running"));
    }
}
