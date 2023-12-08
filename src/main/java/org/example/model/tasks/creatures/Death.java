package org.example.model.tasks.creatures;

import javafx.application.Platform;
import org.example.model.creatures.Creature;
import org.example.model.data.Data;
import org.example.model.tasks.Task;

public class Death extends Task {
    private Creature creature;
    private int tryCount = 0;
    private final int maxTryCount = 3;

    public Death(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void task() throws InterruptedException {
        Thread.sleep(1000);

        if (tryCount >= maxTryCount) {
            creature.setAlive(false);
            if (super.isRunning()) Platform.runLater(() -> {
                creature.stopTasks();
                Data.getInstance().addLogMessage(creature.getName() + " has died!");
            });
        }
        if (!creature.isHealthy() && creature.isHungry()) {
            Thread.sleep(10000);
            tryCount++;
        }
    }
}
