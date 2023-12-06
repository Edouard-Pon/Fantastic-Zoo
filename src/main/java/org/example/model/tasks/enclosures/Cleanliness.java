package org.example.model.tasks.enclosures;

import org.example.model.spaces.Enclosure;

public class Cleanliness implements Runnable {
    private volatile boolean isRunning = true;
    private Enclosure enclosure;

    public Cleanliness(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public void stop() {
        isRunning = false;
    }

    public void run() {
        while (isRunning) {
            try {
                if (enclosure.cleanlinessLevel()) {
                    Thread.sleep(30000);
                    enclosure.setCleanlinessLevel(false);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
