package org.example.model.tasks.creatures;

import javafx.application.Platform;
import org.example.model.creatures.Creature;
import org.example.model.data.Data;

public class Health implements Runnable {
    private volatile boolean isRunning = true;
    private Creature creature;

    public Health(Creature creature) {
        this.creature = creature;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                if (!creature.isHealth()) {
                    Thread.sleep((int) (Math.random() * 21000) + 30000);
                    creature.setHealth(false);
                    Platform.runLater(() -> Data.getInstance().addLogMessage(creature.getName() + " is now sick."));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
