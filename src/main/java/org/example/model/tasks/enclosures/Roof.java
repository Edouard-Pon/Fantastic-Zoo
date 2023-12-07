package org.example.model.tasks.enclosures;

import javafx.application.Platform;
import org.example.model.data.Data;
import org.example.model.spaces.Aviary;
import org.example.model.tasks.Task;

public class Roof extends Task {
    private Aviary aviary;

    public Roof(Aviary aviary) {
        this.aviary = aviary;
    }

    @Override
    public void task() throws InterruptedException {
        if (!aviary.isRoofBroken()) {
            Thread.sleep(45000);
            aviary.setRoofBroken(true);
            if (super.isRunning()) Platform.runLater(() -> Data.getInstance().addLogMessage(aviary.getName() + "'s roof is now broken."));
        }
    }
}
