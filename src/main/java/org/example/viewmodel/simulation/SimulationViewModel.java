package org.example.viewmodel.simulation;

import javafx.beans.property.StringProperty;
import org.example.model.data.Data;
import org.example.model.spaces.Aquarium;
import org.example.model.spaces.Aviary;
import org.example.model.spaces.Enclosure;

import java.util.ArrayList;

public class SimulationViewModel {
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
}
