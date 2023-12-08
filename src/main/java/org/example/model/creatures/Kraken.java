package org.example.model.creatures;

import javafx.application.Platform;
import org.example.model.data.Data;
import org.example.model.reproduction.Oviparous;
import org.example.model.abilities.Swimming;

public class Kraken extends Oviparous implements Swimming {

    /**
     * Constructor of Kraken
     * @param name
     * @param gender
     * @param weight
     * @param height
     * @param age
     */
    public Kraken(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    /**
     * Kraken is swimming
     */
    @Override
    public void swim() {
        Platform.runLater(() -> Data.getInstance().addLogMessage(this.getName() + " is swimming!"));
    }
}
