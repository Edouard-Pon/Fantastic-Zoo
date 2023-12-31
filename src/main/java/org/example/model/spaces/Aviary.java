package org.example.model.spaces;

import org.example.model.creatures.Creature;
import org.example.model.abilities.Flying;
import org.example.model.tasks.TaskManager;
import org.example.model.tasks.enclosures.Roof;

import java.util.HashMap;

public class Aviary extends Enclosure {
    private int height;
    private boolean isRoofBroken; // TODO Replace with Enum and rename it to roofStatus

    /**
     * Constructor for Aviary
     * @param name
     * @param area
     * @param maxCreaturesNumber
     * @param height
     */
    public Aviary(String name, String area, int maxCreaturesNumber, int height) {
        super(name, area, maxCreaturesNumber);
        isRoofBroken = false;
        this.height = height;
        super.getTaskManager().startTasks(
                new Roof(this)
        );
    }

    /**
     * Maintains the Aviary
     * @return true if the Aviary is maintained successfully
     */
    @Override
    public boolean maintain() {
        if (!super.maintain()) return false;
        isRoofBroken = false;
        return true;
    }

    /**
     * Adds creatures to the Aviary
     * @param creatures
     */
    @Override
    public void addCreatures(Creature... creatures) {
        if (creatures == null) return;
        String creatureType = "";

        for (Creature creature : creatures) {
            if (creature instanceof Flying) {
                creatureType = creature.getClass().getName();
                break;
            }
        }

        if (this.getNumberOfCreatures() != 0) {
            creatureType = this.getCreaturesList().get(0).getClass().getName();
        }

        for (Creature creature : creatures) {
            if (creature instanceof Flying && creature.getClass().getName().equals(creatureType)) {
                super.addCreatures(creature);
            }
        }
    }

    /**
     * Check if the roof is broken
     * @return true if the roof is broken
     */
    public boolean isRoofBroken() {
        return isRoofBroken;
    }

    /**
     * Set the roof status
     * @param roofBroken
     */
    public void setRoofBroken(boolean roofBroken) {
        this.isRoofBroken = roofBroken;
    }

    /**
     * Get the characteristics of the Aviary
     * @return HashMap of characteristics
     */
    @Override
    public HashMap<String, String> getCharacteristics() {
        HashMap<String, String> characteristics = super.getCharacteristics();

        characteristics.put("Height", String.valueOf(height));
        if (isRoofBroken) characteristics.put("RoofStatus", "Broken");
        else characteristics.put("RoofStatus", "Fixed");

        return characteristics;
    }
}
