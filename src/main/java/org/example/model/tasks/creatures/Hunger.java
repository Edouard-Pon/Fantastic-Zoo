package org.example.model.tasks.creatures;

import javafx.application.Platform;
import org.example.model.creatures.Creature;
import org.example.model.data.Data;
import org.example.model.tasks.Task;

public class Hunger extends Task {
    private Creature creature;

    public Hunger(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void task() throws InterruptedException {
        if (!creature.isHunger()) {
            Thread.sleep((int) (Math.random() * 6000) + 5000);
            creature.setHunger(true);
            if (super.isRunning()) Platform.runLater(() -> Data.getInstance().addLogMessage(creature.getName() + " is hungry!"));
        }
    }
}
