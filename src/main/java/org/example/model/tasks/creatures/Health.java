package org.example.model.tasks.creatures;

import javafx.application.Platform;
import org.example.model.creatures.Creature;
import org.example.model.data.Data;
import org.example.model.tasks.Task;

public class Health extends Task {
    private Creature creature;

    public Health(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void task() throws InterruptedException {
        if (creature.isHealthy()) {
            Thread.sleep((int) (Math.random() * 21000) + 30000);
            creature.setHealth(false);
            if (super.isRunning()) Platform.runLater(() -> Data.getInstance().addLogMessage(creature.getName() + " is now sick."));
        }
    }
}
