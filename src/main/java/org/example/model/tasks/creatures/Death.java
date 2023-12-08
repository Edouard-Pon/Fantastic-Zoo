package org.example.model.tasks.creatures;

import javafx.application.Platform;
import org.example.model.creatures.Creature;
import org.example.model.creatures.Dragon;
import org.example.model.creatures.Nymph;
import org.example.model.creatures.Phoenix;
import org.example.model.data.Data;
import org.example.model.tasks.Task;

public class Death extends Task {
    private Creature creature;
    private int tryCount = 0;
    private final int maxTryCount = 3;

    /**
     * Constructor of Death task
     * @param creature
     */
    public Death(Creature creature) {
        this.creature = creature;
    }

    /**
     * Task of Death
     * @throws InterruptedException
     */
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
        if (!creature.isAlive()) {
            Thread.sleep(3000);
            if (creature instanceof Dragon) ((Dragon) creature).reborn();
            else if (creature instanceof Nymph) ((Nymph) creature).reborn();
            else if (creature instanceof Phoenix) ((Phoenix) creature).reborn();
        }
        if (!creature.isHealthy() && creature.isHungry()) {
            Thread.sleep(10000);
            tryCount++;
        } else {
            tryCount = 0;
        }
    }
}
