package org.example.model.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.model.management.Master;
import org.example.model.zoo.FantasticZoo;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Data {
    private static Data instance = null;
    private ArrayList<Master> mastersList;
    private ArrayList<FantasticZoo> fantasticZoosList;
    private FantasticZoo currentZoo;
    private ObservableList logMessages;

    private Data() {
        mastersList = new ArrayList<>();
        fantasticZoosList = new ArrayList<>();
        currentZoo = null;
        logMessages = FXCollections.observableArrayList(new CopyOnWriteArrayList<>());
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public void addMaster(Master master) {
        mastersList.add(master);
    }

    public void addFantasticZoo(FantasticZoo fantasticZoo) {
        fantasticZoosList.add(fantasticZoo);
    }

    public Master getMaster(String name) {
        for (Master master : mastersList) {
            if (master.getName().equals(name)) {
                return master;
            }
        }
        return null;
    }

    public FantasticZoo getFantasticZoo(String name) {
        for (FantasticZoo fantasticZoo : fantasticZoosList) {
            if (fantasticZoo.getName().equals(name)) {
                return fantasticZoo;
            }
        }
        return null;
    }

    public Iterable<Master> getMastersList() {
        return mastersList;
    }

    public Iterable<FantasticZoo> getFantasticZoosList() {
        return fantasticZoosList;
    }

    public void setCurrentZoo(FantasticZoo fantasticZoo) {
        currentZoo = fantasticZoo;
    }

    public FantasticZoo getCurrentZoo() {
        return currentZoo;
    }

    public void addLogMessage(String message) {
        logMessages.add(message);
    }

    public ObservableList<String> logMessagesProperty() {
        return logMessages;
    }
}
