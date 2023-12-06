package org.example.model.tasks.creatures;

import org.example.model.creatures.Creature;

public class Aging implements Runnable {
    private volatile boolean isRunning = true;
    private Creature creature;

    public Aging(Creature creature) {
        this.creature = creature;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(10000);
                creature.setAge(creature.getAge() + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
