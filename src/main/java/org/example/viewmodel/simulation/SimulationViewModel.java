package org.example.viewmodel.simulation;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import org.example.model.creatures.*;
import org.example.model.data.Data;
import org.example.model.data.DataImages;
import org.example.model.spaces.Aquarium;
import org.example.model.spaces.Aviary;
import org.example.model.spaces.Enclosure;
import org.example.model.zoo.FantasticZoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SimulationViewModel {
    private Enclosure currentEnclosure;
    private Creature currentCreature;

    public SimulationViewModel() {}

    public StringProperty currentZooNameProperty() {
        return Data.getInstance().getCurrentZoo().nameProperty();
    }

    public boolean createEnclosure(String name, String type, String area, String maxCreatures, String height, String depth, String waterSalinity) {
        if (type == null || type.isEmpty() || name.isEmpty() || area.isEmpty() || maxCreatures.isEmpty()) return false;
        switch (type) {
            case "Aquarium" -> {
                if (depth.isEmpty() || waterSalinity.isEmpty()) return false;
                Data.getInstance().getCurrentZoo().addEnclosure(new Aquarium(name, area, Integer.parseInt(maxCreatures), Integer.parseInt(depth), Double.parseDouble(waterSalinity)));
            }
            case "Aviary" -> {
                if (height.isEmpty()) return false;
                Data.getInstance().getCurrentZoo().addEnclosure(new Aviary(name, area, Integer.parseInt(maxCreatures), Integer.parseInt(height)));
            }
            case "Default" -> {
                Data.getInstance().getCurrentZoo().addEnclosure(new Enclosure(name, area, Integer.parseInt(maxCreatures)));
            }
        }
        return true;
    }

    public ArrayList<String> currentZooEnclosuresNamesList() {
        ArrayList<String> enclosureNames = new ArrayList<>();
        for (Enclosure enclosure : Data.getInstance().getCurrentZoo().getEnclosureList()) {
            enclosureNames.add(enclosure.getName());
        }
        return enclosureNames;
    }

    public boolean createCreature(String creatureType, String creatureName, String creatureGender, String creatureWeight, String creatureHeight, String creatureAge, String creatureEnclosure) {
        if (creatureType == null || creatureType.isEmpty() || creatureName.isEmpty() || creatureGender == null || creatureGender.isEmpty() || creatureWeight.isEmpty() || creatureHeight.isEmpty() || creatureAge.isEmpty() || creatureEnclosure.isEmpty()) return false;

        Enclosure enclosure = Data.getInstance().getCurrentZoo().getEnclosureByName(creatureEnclosure);

        switch (creatureType) {
            case "Dragon" -> enclosure.addCreatures(new Dragon(creatureName, creatureGender.equals("Male"), Integer.parseInt(creatureWeight), Integer.parseInt(creatureHeight), Integer.parseInt(creatureAge)));
            case "Kraken" -> enclosure.addCreatures(new Kraken(creatureName, creatureGender.equals("Male"), Integer.parseInt(creatureWeight), Integer.parseInt(creatureHeight), Integer.parseInt(creatureAge)));
            case "Lycanthrope" -> enclosure.addCreatures(new Lycanthrope(creatureName, creatureGender.equals("Male"), Integer.parseInt(creatureWeight), Integer.parseInt(creatureHeight), Integer.parseInt(creatureAge)));
            case "Megalodon" -> enclosure.addCreatures(new Megalodon(creatureName, creatureGender.equals("Male"), Integer.parseInt(creatureWeight), Integer.parseInt(creatureHeight), Integer.parseInt(creatureAge)));
            case "Nymph" -> enclosure.addCreatures(new Nymph(creatureName, creatureGender.equals("Male"), Integer.parseInt(creatureWeight), Integer.parseInt(creatureHeight), Integer.parseInt(creatureAge)));
            case "Phoenix" -> enclosure.addCreatures(new Phoenix(creatureName, creatureGender.equals("Male"), Integer.parseInt(creatureWeight), Integer.parseInt(creatureHeight), Integer.parseInt(creatureAge)));
            case "Siren" -> enclosure.addCreatures(new Siren(creatureName, creatureGender.equals("Male"), Integer.parseInt(creatureWeight), Integer.parseInt(creatureHeight), Integer.parseInt(creatureAge)));
            case "Unicorn" -> enclosure.addCreatures(new Unicorn(creatureName, creatureGender.equals("Male"), Integer.parseInt(creatureWeight), Integer.parseInt(creatureHeight), Integer.parseInt(creatureAge)));
        }

        return true;
    }

    public void setCurrentEnclosure(String enclosureName) {
        currentEnclosure = Data.getInstance().getCurrentZoo().getEnclosureByName(enclosureName);
    }

    public Enclosure getCurrentEnclosure() {
        return currentEnclosure;
    }

    public ArrayList<String> currentEnclosureCreaturesNamesList() {
        ArrayList<String> creatureNames = new ArrayList<>();
        if (currentEnclosure == null) return creatureNames;
        for (Creature creature : currentEnclosure.getCreaturesList()) {
            creatureNames.add(creature.getName());
        }
        return creatureNames;
    }

    public void setCurrentZoo(FantasticZoo fantasticZoo) {
        Data.getInstance().setCurrentZoo(fantasticZoo);
    }

    public void setCurrentCreature(String creatureName) {
        currentCreature = currentEnclosure.getCreatureByName(creatureName);
    }

    public void removeCreature(String selectedCreature) {
        currentEnclosure.getCreatureByName(selectedCreature).stopTasks();
        currentEnclosure.removeCreatureByName(selectedCreature);
    }

    public Image getCurrentCreatureImage() {
        return DataImages.getInstance().getImage(currentCreature.getClass().getSimpleName().toLowerCase());
    }

    public Map<String, String> getCreatureStats(Creature creature) {
        if (creature == null) return null;
        Map<String, String> stats = new HashMap<>();

        stats.put("Name", creature.getName());
        stats.put("Weight", String.valueOf(creature.getWeight()));
        stats.put("Height", String.valueOf(creature.getHeight()));
        stats.put("Age", String.valueOf(creature.getAge()));
        stats.put("Type", creature.getClass().getSimpleName());
        stats.put("Alive", creature.isAlive() ? "Alive" : "Dead");
        stats.put("Sleep", creature.isSleeping() ? "Sleeping" : "Not sleeping");
        stats.put("Gender", creature.isGender() ? "Male" : "Female");
        stats.put("Hunger", creature.isHungry() ? "Hungry" : "Not hungry");
        stats.put("Health", creature.isHealthy() ? "Healthy" : "Not healthy");

        return stats;
    }

    public Creature getCurrentCreature() {
        return currentCreature;
    }

    public Map<String, String> getEnclosureStats(Enclosure currentEnclosure) {
        if (currentEnclosure == null) return null;

        return currentEnclosure.getCharacteristics();
    }

    public ObservableList<String> logMessagesProperty() {
        return Data.getInstance().logMessagesProperty();
    }

    public boolean removeEnclosure(String selectedItem) {
        Enclosure enclosure = Data.getInstance().getCurrentZoo().getEnclosureByName(selectedItem);
        if (currentEnclosure == enclosure) setCurrentEnclosure(null);

        if (!Data.getInstance().getCurrentZoo().removeEnclosure(enclosure)) {
            Data.getInstance().addLogMessage("Enclosure " + enclosure.getName() + " is not empty!");
            return false;
        }
        enclosure.stopTasks();
        Data.getInstance().addLogMessage("Enclosure " + enclosure.getName() + " removed!");
        return true;
    }

    public void feedCreature(String creatureName) {
        Creature creature = currentEnclosure.getCreatureByName(creatureName);
        if (creature == null) return;
        if (!creature.isHungry()) return;
        creature.feed();
        Data.getInstance().addLogMessage(creature.getName() + " is fed!");
    }

    public void maintainEnclosure(String enclosureName) {
        Enclosure enclosure = Data.getInstance().getCurrentZoo().getEnclosureByName(enclosureName);
        if (enclosure == null) return;
        if (!enclosure.maintain()) return;
        Data.getInstance().addLogMessage(enclosure.getName() + " is maintained!");
    }

    public void healCreature(String creatureName) {
        Creature creature = currentEnclosure.getCreatureByName(creatureName);
        if (creature == null) return;
        if (creature.isHealthy()) return;
        creature.heal();
        Data.getInstance().addLogMessage(creature.getName() + " is healed!");
    }
}
