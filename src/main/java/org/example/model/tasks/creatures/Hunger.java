package org.example.model.tasks.creatures;

import javafx.application.Platform;
import org.example.model.creatures.Creature;
import org.example.model.data.Data;

public class Hunger implements Runnable {
    private volatile boolean isRunning = true;
    private Creature creature;

    public Hunger(Creature creature) {
        this.creature = creature;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                if (!creature.isHunger()) {
                    Thread.sleep((int) (Math.random() * 6000) + 5000);
                    creature.setHunger(true);
                    Platform.runLater(() -> Data.getInstance().addLogMessage(creature.getName() + " is hungry!"));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
