package org.example.model.spaces;

import org.example.model.creatures.Creature;
import org.example.model.abilities.Swimming;
import org.example.model.tasks.enclosures.Depth;
import org.example.model.tasks.enclosures.WaterSalinity;

import java.util.HashMap;

public class Aquarium extends Enclosure {
    private int depth; // TODO Replace with better solution
    private int defaultDepth;
    private double waterSalinity; // TODO Replace with better solution, maybe Enum?
    private double defaultWaterSalinity;

    public Aquarium(String name, String area, int maxCreaturesNumber, int depth, double waterSalinity) {
        super(name, area, maxCreaturesNumber);
        this.depth = depth;
        this.defaultDepth = depth;
        this.waterSalinity = waterSalinity;
        this.defaultWaterSalinity = waterSalinity;
        super.getTaskManager().startTasks(
                new WaterSalinity(this),
                new Depth(this)
        );
    }

    // TODO Update the depth and water salinity check
    @Override
    public boolean maintain() {
        if (!super.maintain()) return false;
        waterSalinity = defaultWaterSalinity;
        depth = defaultDepth;
        return true;
    }

    @Override
    public void addCreatures(Creature... creatures) {
        if (creatures == null) return;
        String creatureType = "";

        for (Creature creature : creatures) {
            if (creature instanceof Swimming) {
                creatureType = creature.getClass().getName();
                break;
            }
        }

        if (this.getNumberOfCreatures() != 0) {
            creatureType = this.getCreaturesList().get(0).getClass().getName();
        }

        for (Creature creature : creatures) {
            if (creature instanceof Swimming && creature.getClass().getName().equals(creatureType)) {
                super.addCreatures(creature);
            }
        }
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public double getWaterSalinity() {
        return waterSalinity;
    }

    public void setWaterSalinity(double waterSalinity) {
        this.waterSalinity = waterSalinity;
    }

    @Override
    public HashMap<String, String> getCharacteristics() {
        HashMap<String, String> characteristics = super.getCharacteristics();

        characteristics.put("Depth", String.valueOf(depth));
        characteristics.put("WaterSalinity", String.valueOf(waterSalinity));

        return characteristics;
    }
}
