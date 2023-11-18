package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Enclosure {
    private String name;
    private String area;
    private int maxCreaturesNumber;
    private int numberOfCreatures;
    private ArrayList<Creature> creaturesList;
    private boolean cleanlinessLevel; // TODO Replace with Enum

    public Enclosure(String name, String area, int maxCreaturesNumber) {
        this.name = name;
        this.area = area;
        this.maxCreaturesNumber = maxCreaturesNumber;
        this.cleanlinessLevel = true;
        this.numberOfCreatures = 0;
    }

    // TODO Finish the getCharacteristics
    public void getCharacteristics() {
        return;
    }

    // TODO Add verification process
    public void addCreatures(Creature... creatures) {
        if (creatures != null) {
            numberOfCreatures += creatures.length;
            creaturesList.addAll(Arrays.asList(creatures));
        }
    }

    // TODO Add removing specific creatures
    public void removeCreatures() {
        creaturesList.clear();
    }

    public void feedCreatures() {
        for (Creature creature : creaturesList) {
            creature.eat();
        }
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public int getMaxCreaturesNumber() {
        return maxCreaturesNumber;
    }

    public int getNumberOfCreatures() {
        return numberOfCreatures;
    }

    public ArrayList<Creature> getCreaturesList() {
        return creaturesList;
    }

    public boolean cleanlinessLevel() {
        return cleanlinessLevel;
    }
}
