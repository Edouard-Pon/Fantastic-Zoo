package org.example.model.creatures;

import javafx.application.Platform;
import org.example.model.abilities.Swimming;
import org.example.model.data.Data;
import org.example.model.reproduction.Viviparous;

public class Siren extends Viviparous implements Swimming {
    public Siren(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    @Override
    public void swim() {
        Platform.runLater(() -> Data.getInstance().addLogMessage(getName() + " is swimming"));
    }
}
