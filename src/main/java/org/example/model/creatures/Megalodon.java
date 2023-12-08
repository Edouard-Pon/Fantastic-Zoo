package org.example.model.creatures;

import javafx.application.Platform;
import org.example.model.data.Data;
import org.example.model.reproduction.Oviparous;
import org.example.model.abilities.Swimming;

public class Megalodon extends Oviparous implements Swimming {

    /**
     * Constructor of Megalodon
     * @param name
     * @param gender
     * @param weight
     * @param height
     * @param age
     */
    public Megalodon(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    /**
     * Megalodon is swimming
     */
    @Override
    public void swim() {
        Platform.runLater(() -> Data.getInstance().addLogMessage("Megalodon " + this.getName() + " is swimming"));
    }
}
