package org.example.model.tasks.creatures;

import org.example.model.creatures.Creature;

public class Hunger implements Runnable {
    private volatile boolean isRunning = true;
    private Creature creature;

    public Hunger(Creature creature) {
        this.creature = creature;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep((int) (Math.random() * 6000) + 5000);
                creature.setHunger(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
