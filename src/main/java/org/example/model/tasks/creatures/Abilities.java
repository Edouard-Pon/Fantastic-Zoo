package org.example.model.tasks.creatures;

import org.example.model.abilities.Flying;
import org.example.model.abilities.Running;
import org.example.model.abilities.Swimming;
import org.example.model.creatures.Creature;
import org.example.model.tasks.Task;

import java.util.Random;

public class Abilities extends Task {
    private Creature creature;
    private Random random = new Random();

    public Abilities(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void task() throws InterruptedException {
        int randomNumber = (int) (Math.random() * 10);

        if (randomNumber < 4) {
            if (creature instanceof Flying) {
                if (random.nextBoolean()) {
                    ((Flying) creature).fly();
                    Thread.sleep(3000);
                }
            }
            if (creature instanceof Running) {
                if (random.nextBoolean()) {
                    ((Running) creature).run();
                    Thread.sleep(3000);
                }
            }
            if (creature instanceof Swimming) {
                if (random.nextBoolean()) {
                    ((Swimming) creature).swim();
                    Thread.sleep(3000);
                }
            }
        }
        Thread.sleep(15000);
    }
}
