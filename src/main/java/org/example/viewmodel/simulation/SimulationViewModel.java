package org.example.viewmodel.simulation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.example.model.data.Data;

public class SimulationViewModel {
    public SimulationViewModel() {}

    public StringProperty currentZooNameProperty() {
        return Data.getInstance().getCurrentZoo().nameProperty();
    }
}
