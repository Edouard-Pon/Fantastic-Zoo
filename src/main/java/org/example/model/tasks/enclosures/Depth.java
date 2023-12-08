package org.example.model.tasks.enclosures;

import javafx.application.Platform;
import org.example.model.data.Data;
import org.example.model.spaces.Aquarium;
import org.example.model.tasks.Task;

import java.util.Random;

public class Depth extends Task {
    private Aquarium aquarium;
    private Random random;

    /**
     * Constructor of Depth
     * @param aquarium
     */
    public Depth(Aquarium aquarium) {
        this.aquarium = aquarium;
        this.random = new Random();
    }

    /**
     * Decreases the depth of the aquarium by a random number between 5 and 10
     * @throws InterruptedException
     */
    @Override
    public void task() throws InterruptedException {
        Thread.sleep(60000);
        int decrease = random.nextInt(6) + 5;
        int newDepth = aquarium.getDepth() - decrease;
        if (newDepth < 0) newDepth = 0;
        aquarium.setDepth(newDepth);
        if (super.isRunning()) Platform.runLater(() -> Data.getInstance().addLogMessage(aquarium.getName() + "'s depth is now " + aquarium.getDepth() + " meters."));
    }
}
