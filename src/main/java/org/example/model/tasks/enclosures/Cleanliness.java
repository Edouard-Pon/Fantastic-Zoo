package org.example.model.tasks.enclosures;

import javafx.application.Platform;
import org.example.model.data.Data;
import org.example.model.spaces.Enclosure;
import org.example.model.tasks.Task;

public class Cleanliness extends Task {
    private Enclosure enclosure;

    public Cleanliness(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    @Override
    public void task() throws InterruptedException {
        if (enclosure.isClean()) {
            Thread.sleep(30000);
            enclosure.setClean(false);
            if (super.isRunning()) Platform.runLater(() -> Data.getInstance().addLogMessage(enclosure.getName() + " is now dirty."));
        }
    }
}
