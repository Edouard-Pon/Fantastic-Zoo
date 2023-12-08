package org.example.model.spaces;

import org.example.model.creatures.Creature;
import org.example.model.data.Data;
import org.example.model.tasks.TaskManager;
import org.example.model.tasks.creatures.Reproduction;
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

    /**
     * Constructor for Enclosure
     * @param name
     * @param area
     * @param maxCreaturesNumber
     */
    public Enclosure(String name, String area, int maxCreaturesNumber) {
        this.name = name;
        this.area = area;
        this.maxCreaturesNumber = maxCreaturesNumber;
        this.isClean = true;
        this.numberOfCreatures = 0;
        this.creaturesList = new ArrayList<>();
        this.taskManager = new TaskManager();
        taskManager.startTasks(
                new Cleanliness(this),
                new Reproduction(this)
        );
    }

    /**
     * Get characteristics of the enclosure
     * @return HashMap of characteristics
     */
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
    /**
     * Add creatures to the enclosure
     * @param creatures
     */
    public void addCreatures(Creature... creatures) {
        if (creatures != null && maxCreaturesNumber > creaturesList.size()) {
            for (Creature creature : creatures) {
                if (numberOfCreatures == maxCreaturesNumber) break;
                // TODO Not working with Java < 21
//                if (!creaturesList.isEmpty() && creaturesList.getFirst().getClass() != creature.getClass()) break;
                if (!creaturesList.isEmpty() && creaturesList.get(0).getClass() != creature.getClass()) break;
                numberOfCreatures++;
                creaturesList.add(creature);
            }
        }
    }

    // TODO Add removing specific creatures
    /**
     * Remove creatures from the enclosure
     */
    public void removeCreatures() {
        creaturesList.clear();
        numberOfCreatures = 0;
    }

    /**
     * Remove creature from the enclosure
     * @param creature
     */
    public void removeCreature(Creature creature) {
        creaturesList.remove(creature);
        numberOfCreatures--;
    }

    /**
     * Remove creature from the enclosure by name
     * @param name
     */
    public void removeCreatureByName(String name) {
        for (Creature creature : creaturesList) {
            if (creature.getName().equals(name)) {
                creaturesList.remove(creature);
                numberOfCreatures--;
                break;
            }
        }
    }

    /**
     * Feed creatures in the enclosure
     */
    public void feedCreatures() {
        for (Creature creature : creaturesList) {
            creature.eat();
        }
    }

    /**
     * Maintain the enclosure
     */
    public boolean maintain() {
        if (!creaturesList.isEmpty()) {
            Data.getInstance().addLogMessage("Enclosure " + name + " is not empty. Cannot maintain.");
            return false;
        }
        isClean = true;
        return true;
    }

    /**
     * Get name of the enclosure
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get area of the enclosure
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * Get maximum number of creatures in the enclosure
     * @return maxCreaturesNumber
     */
    public int getMaxCreaturesNumber() {
        return maxCreaturesNumber;
    }

    /**
     * Get number of creatures in the enclosure
     * @return numberOfCreatures
     */
    public int getNumberOfCreatures() {
        return numberOfCreatures;
    }

    /**
     * Get list of creatures in the enclosure
     * @return creaturesList
     */
    public ArrayList<Creature> getCreaturesList() {
        return creaturesList;
    }

    /**
     * Get cleanliness level of the enclosure
     * @return isClean
     */
    public boolean isClean() {
        return isClean;
    }

    /**
     * Set cleanliness level of the enclosure
     * @param cleanlinessLevel
     */
    public void setClean(boolean cleanlinessLevel) {
        this.isClean = cleanlinessLevel;
    }

    /**
     * Get creature from the enclosure by name
     * @param name
     * @return creature
     */
    public Creature getCreatureByName(String name) {
        for (Creature creature : creaturesList) {
            if (creature.getName().equals(name)) return creature;
        }
        return null;
    }

    /**
     * Stop all tasks in the enclosure
     */
    public void stopTasks() {
        taskManager.stopTasks();
    }

    /**
     * Get task manager of the enclosure
     * @return taskManager
     */
    protected TaskManager getTaskManager() {
        return taskManager;
    }
}
