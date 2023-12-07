package org.example.model.spaces;

import org.example.model.creatures.Creature;
import org.example.model.data.Data;
import org.example.model.tasks.TaskManager;
import org.example.model.tasks.enclosures.Cleanliness;

import java.util.ArrayList;
import java.util.HashMap;

public class Enclosure {
    private String name;
    private String area;
    private int maxCreaturesNumber;
    private int numberOfCreatures;
    private ArrayList<Creature> creaturesList;
    private boolean isClean; // TODO Replace with Enum
    private TaskManager taskManager;

    public Enclosure(String name, String area, int maxCreaturesNumber) {
        this.name = name;
        this.area = area;
        this.maxCreaturesNumber = maxCreaturesNumber;
        this.isClean = true;
        this.numberOfCreatures = 0;
        this.creaturesList = new ArrayList<>();
        this.taskManager = new TaskManager();
        taskManager.startTasks(
                new Cleanliness(this)
        );
    }

    // TODO Finish the getCharacteristics
    public HashMap<String, String> getCharacteristics() {
        HashMap<String, String> characteristics = new HashMap<String, String>();

        characteristics.put("Name", name);
        characteristics.put("Area", area);
        if (isClean) characteristics.put("CleanlinessLevel", "Clean");
        else characteristics.put("CleanlinessLevel", "Dirty");
        characteristics.put("CreaturesInside", creaturesList.toString());
        characteristics.put("CreaturesCount", String.valueOf(numberOfCreatures));
        characteristics.put("MaxCreaturesNumber", String.valueOf(maxCreaturesNumber));
        characteristics.put("Type", this.getClass().getSimpleName());

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

    public boolean maintain() {
        if (!creaturesList.isEmpty()) {
            Data.getInstance().addLogMessage("Enclosure " + name + " is not empty. Cannot maintain.");
            return false;
        }
        isClean = true;
        return true;
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

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean cleanlinessLevel) {
        this.isClean = cleanlinessLevel;
    }

    public Creature getCreatureByName(String name) {
        for (Creature creature : creaturesList) {
            if (creature.getName().equals(name)) return creature;
        }
        return null;
    }

    public void stopTasks() {
        taskManager.stopTasks();
    }

    protected TaskManager getTaskManager() {
        return taskManager;
    }
}
