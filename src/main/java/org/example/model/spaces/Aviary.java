package org.example.model.spaces;

import org.example.model.creatures.Creature;
import org.example.model.abilities.Flying;

public class Aviary extends Enclosure {
    private int height;
    private boolean roofBroken; // TODO Replace with Enum and rename it to roofStatus

    public Aviary(String name, String area, int maxCreaturesNumber, int height) {
        super(name, area, maxCreaturesNumber);
        roofBroken = false;
        this.height = height;
    }

    @Override
    public void maintain() {
        if (!super.cleanlinessLevel() && super.getCreaturesList().isEmpty()) {
            super.maintain();
            roofBroken = false;
        }
    }

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

    public boolean isRoofBroken() {
        return roofBroken;
    }

    public void setRoofBroken(boolean roofBroken) {
        this.roofBroken = roofBroken;
    }
}
