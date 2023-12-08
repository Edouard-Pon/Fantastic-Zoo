package org.example.model.tasks.enclosures;

import javafx.application.Platform;
import org.example.model.data.Data;
import org.example.model.spaces.Aquarium;
import org.example.model.tasks.Task;

import java.util.Random;

public class WaterSalinity extends Task {
    private Aquarium aquarium;
    private Random random;

    /**
     * Constructor of the WaterSalinity task.
     * @param aquarium
     */
    public WaterSalinity(Aquarium aquarium) {
        this.aquarium = aquarium;
        this.random = new Random();
    }

    /**
     * Decreases the water salinity of the aquarium by a random number between 0 and 2.
     * If the water salinity is less than 0, it is set to 0.
     * @throws InterruptedException
     */
    @Override
    public void task() throws InterruptedException {
        Thread.sleep(120000);
        int decrease = random.nextInt(3);
        double newWaterSalinity = aquarium.getWaterSalinity() - decrease;
        if (newWaterSalinity < 0) newWaterSalinity = 0;
        aquarium.setWaterSalinity(newWaterSalinity);
        if (super.isRunning()) Platform.runLater(() -> Data.getInstance().addLogMessage(aquarium.getName() + "'s water salinity is now " + aquarium.getWaterSalinity() + "."));
    }
}
