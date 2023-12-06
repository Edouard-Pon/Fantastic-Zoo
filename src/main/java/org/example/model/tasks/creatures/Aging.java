package org.example.model.tasks.creatures;

import javafx.application.Platform;
import org.example.model.creatures.Creature;
import org.example.model.data.Data;

public class Aging implements Runnable {
    private volatile boolean isRunning = true;
    private Creature creature;

    public Aging(Creature creature) {
        this.creature = creature;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(10000);
                creature.setAge(creature.getAge() + 1);
                // TODO Remove if not needed or uncomment if needed
//                Platform.runLater(() -> Data.getInstance().addLogMessage(creature.getName() + " is now " + creature.getAge() + " years old."));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
