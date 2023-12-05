package org.example.model.spaces;

import org.example.model.creatures.Creature;

import java.util.ArrayList;
import java.util.HashMap;

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
        this.creaturesList = new ArrayList<>();
    }

    // TODO Finish the getCharacteristics
    public HashMap<String, String> getCharacteristics() {
        HashMap<String, String> characteristics = new HashMap<String, String>();
        characteristics.put("Name", name);
        characteristics.put("Area", area);
        characteristics.put("Cleanliness Level", String.valueOf(cleanlinessLevel));
        characteristics.put("Creatures inside",creaturesList.toString());
        return characteristics;
    }

    // TODO Add verification process
    public void addCreatures(Creature... creatures) {
        if (creatures != null && maxCreaturesNumber > creaturesList.size()) {
            for (Creature creature : creatures) {
                if (numberOfCreatures == maxCreaturesNumber) break;
                if (!creaturesList.isEmpty() && creaturesList.getFirst().getClass() != creature.getClass()) break;
                numberOfCreatures++;
                creaturesList.add(creature);
            }
        }
    }

    // TODO Add removing specific creatures
    public void removeCreatures() {
        creaturesList.clear();
        numberOfCreatures = 0;
    }

    public void removeCreature(Creature creature) {
        creaturesList.remove(creature);
        numberOfCreatures--;
    }

    public void removeCreatureByName(String name) {
        for (Creature creature : creaturesList) {
            if (creature.getName().equals(name)) {
                creaturesList.remove(creature);
                numberOfCreatures--;
                break;
            }
        }
    }

    public void feedCreatures() {
        for (Creature creature : creaturesList) {
            creature.eat();
        }
    }

    public void maintain() {
        if (!cleanlinessLevel && creaturesList.isEmpty()) {
            cleanlinessLevel = true;
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

    public void setCleanlinessLevel(boolean cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }
}
