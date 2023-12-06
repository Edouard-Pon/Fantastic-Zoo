package org.example.model.tasks.creatures;

import javafx.application.Platform;
import org.example.model.creatures.Creature;
import org.example.model.data.Data;

public class Sleep implements Runnable {
    private volatile boolean isRunning = true;
    private Creature creature;

    public Sleep(Creature creature) {
        this.creature = creature;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                int randomNumber = (int) (Math.random() * 10);

                if (randomNumber < 3) {
                    creature.setSleeping(true);
                    Platform.runLater(() -> Data.getInstance().addLogMessage(creature.getName() + " is now sleeping."));

                    int sleepDuration = (int) (Math.random() * 6000) + 10000;

                    Thread.sleep(sleepDuration);

                    creature.setSleeping(false);
                    Platform.runLater(() -> Data.getInstance().addLogMessage(creature.getName() + " is now awake."));
                } else {
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
