package org.example.model.creatures;

import javafx.application.Platform;
import org.example.model.abilities.Running;
import org.example.model.data.Data;
import org.example.model.reproduction.Viviparous;

public class Unicorn extends Viviparous implements Running {
    public Unicorn(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public void run() {
        Platform.runLater(() -> Data.getInstance().addLogMessage(getName() + " is running"));
    }
}
