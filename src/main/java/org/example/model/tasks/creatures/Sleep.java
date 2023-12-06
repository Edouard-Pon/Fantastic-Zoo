package org.example.model.tasks.creatures;

import org.example.model.creatures.Creature;

public class Sleep implements Runnable {
    private volatile boolean isRunning = true;
    private Creature creature;

    public Sleep(Creature creature) {
        this.creature = creature;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                int randomNumber = (int) (Math.random() * 10);

                if (randomNumber < 3) {
                    creature.setSleeping(true);

                    int sleepDuration = (int) (Math.random() * 6000) + 10000;

                    Thread.sleep(sleepDuration);

                    creature.setSleeping(false);
                } else {
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
