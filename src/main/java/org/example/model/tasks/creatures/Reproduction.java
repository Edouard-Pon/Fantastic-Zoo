package org.example.model.tasks.creatures;

import javafx.application.Platform;
import org.example.model.creatures.Creature;
import org.example.model.creatures.CreatureFactory;
import org.example.model.data.Data;
import org.example.model.spaces.Enclosure;
import org.example.model.tasks.Task;

import java.util.Random;

// TODO Update entirely the reproduction task
public class Reproduction extends Task {
    Enclosure enclosure;
    Creature firstCreature;
    Creature secondCreature;
    Creature child;
    Random random;

    /**
     * Constructor of the reproduction task
     * @param enclosure
     */
    public Reproduction(Enclosure enclosure) {
        this.enclosure = enclosure;
        random = new Random();
    }

    /**
     * Method that runs the reproduction task
     * @throws InterruptedException
     */
    @Override
    public void task() throws InterruptedException {
        Thread.sleep(180000);
        getCreatures();
        if (firstCreature == secondCreature) {
            if (super.isRunning()) Platform.runLater(() -> Data.getInstance().addLogMessage("Creature " + firstCreature.getName() + " tried to reproduce with itself"));
        }
        else reproduce();
    }

    /**
     * Method that gets two creatures from the enclosure
     */
    private void getCreatures() {
        firstCreature = enclosure.getCreaturesList().get(random.nextInt(enclosure.getCreaturesList().size()));
        secondCreature = enclosure.getCreaturesList().get(random.nextInt(enclosure.getCreaturesList().size()));
        while (firstCreature.isGender() == secondCreature.isGender()) {
            secondCreature = enclosure.getCreaturesList().get(random.nextInt(enclosure.getCreaturesList().size()));
        }
    }

    // TODO Separate the reproduction and the birth tasks
    /**
     * Method that reproduces two creatures
     */
    private void reproduce() {
        if (firstCreature.isGender() != secondCreature.isGender()) {
            if (super.isRunning()) Platform.runLater(() -> Data.getInstance().addLogMessage("Creature " + firstCreature.getName() + " reproduced with " + secondCreature.getName()));
            child = CreatureFactory.getInstance().createCreature(firstCreature.getClass().getSimpleName(), firstCreature, secondCreature, enclosure);
            enclosure.addCreatures(child);
            if (super.isRunning()) Platform.runLater(() -> Data.getInstance().addLogMessage("Creature " + child.getName() + " was born!"));
        }
    }
}
