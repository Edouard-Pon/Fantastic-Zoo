package org.example.viewmodel.simulation;

import javafx.beans.property.StringProperty;
import org.example.model.creatures.*;
import org.example.model.data.Data;
import org.example.model.spaces.Aquarium;
import org.example.model.spaces.Aviary;
import org.example.model.spaces.Enclosure;
import org.example.model.zoo.FantasticZoo;

import java.util.ArrayList;

public class SimulationViewModel {
    private Enclosure currentEnclosure;

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

    public void removeCreature(String selectedCreature) {
        currentEnclosure.removeCreatureByName(selectedCreature);
    }
}
