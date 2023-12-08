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

    /**
     * Private constructor for Data class.
     */
    private Data() {
        mastersList = new ArrayList<>();
        fantasticZoosList = new ArrayList<>();
        currentZoo = null;
        logMessages = FXCollections.observableArrayList(new CopyOnWriteArrayList<>());
    }

    /**
     * Returns the instance of Data class.
     *
     * @return the instance of Data class.
     */
    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    /**
     * Adds a master to the masters list.
     * @param master
     */
    public void addMaster(Master master) {
        mastersList.add(master);
    }

    /**
     * Adds a fantastic zoo to the fantastic zoos list.
     * @param fantasticZoo
     */
    public void addFantasticZoo(FantasticZoo fantasticZoo) {
        fantasticZoosList.add(fantasticZoo);
    }

    /**
     * Returns the master with the given name.
     * @param name
     * @return the master with the given name.
     */
    public Master getMaster(String name) {
        for (Master master : mastersList) {
            if (master.getName().equals(name)) {
                return master;
            }
        }
        return null;
    }

    /**
     * Returns the fantastic zoo with the given name.
     * @param name
     * @return the fantastic zoo with the given name.
     */
    public FantasticZoo getFantasticZoo(String name) {
        for (FantasticZoo fantasticZoo : fantasticZoosList) {
            if (fantasticZoo.getName().equals(name)) {
                return fantasticZoo;
            }
        }
        return null;
    }

    /**
     * Returns the masters list.
     * @return Iterable of masters.
     */
    public Iterable<Master> getMastersList() {
        return mastersList;
    }

    /**
     * Returns the fantastic zoos list.
     * @return Iterable of fantastic zoos.
     */
    public Iterable<FantasticZoo> getFantasticZoosList() {
        return fantasticZoosList;
    }

    /**
     * Sets the current zoo.
     * @param fantasticZoo
     */
    public void setCurrentZoo(FantasticZoo fantasticZoo) {
        currentZoo = fantasticZoo;
    }

    /**
     * Returns the current zoo.
     * @return FantasticZoo
     */
    public FantasticZoo getCurrentZoo() {
        return currentZoo;
    }

    /**
     * Adds a log message to the log messages list.
     * @param message
     */
    public void addLogMessage(String message) {
        logMessages.add(message);
    }

    /**
     * Returns the log messages list.
     * @return ObservableList of log messages.
     */
    public ObservableList<String> logMessagesProperty() {
        return logMessages;
    }
}
