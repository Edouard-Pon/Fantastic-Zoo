package org.example.model.tasks.creatures;

import javafx.application.Platform;
import org.example.model.creatures.Creature;
import org.example.model.data.Data;
import org.example.model.tasks.Task;

public class Sleep extends Task {
    private Creature creature;

    public Sleep(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void task() throws InterruptedException {
        int randomNumber = (int) (Math.random() * 10);

        if (randomNumber < 3) {
            creature.setSleeping(true);
            if (super.isRunning()) Platform.runLater(() -> Data.getInstance().addLogMessage(creature.getName() + " is now sleeping."));

            int sleepDuration = (int) (Math.random() * 6000) + 10000;

            Thread.sleep(sleepDuration);

            creature.setSleeping(false);
            if (super.isRunning()) Platform.runLater(() -> Data.getInstance().addLogMessage(creature.getName() + " is now awake."));
        } else {
            Thread.sleep(5000);
        }
    }
}
