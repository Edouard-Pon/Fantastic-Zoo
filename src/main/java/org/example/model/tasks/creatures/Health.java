package org.example.model.tasks.creatures;

import org.example.model.creatures.Creature;

public class Health implements Runnable {
    private volatile boolean isRunning = true;
    private Creature creature;

    public Health(Creature creature) {
        this.creature = creature;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep((int) (Math.random() * 21000) + 30000);
                creature.setHealth(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
