package org.example.model.zoo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import org.example.model.creatures.Creature;
import org.example.model.management.Master;
import org.example.model.spaces.Enclosure;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FantasticZoo {
    private StringProperty name;
    private Master master;
    private int maxEnclosureNumber;
    private ArrayList<Enclosure> enclosureList;

    public AtomicInteger getNumberOfCreatures(){
        AtomicInteger number = new AtomicInteger();
        enclosureList.forEach((enclosure) -> number.getAndAdd(enclosure.getNumberOfCreatures()));
        return number;
    }
    public ArrayList<Creature> getAllCreatures(){
        ArrayList<Creature> creatures = new ArrayList<Creature>();
        enclosureList.forEach((enclosure) -> creatures.addAll(enclosure.getCreaturesList()));
        return creatures;
    }
    public FantasticZoo(String name, Master master, int maxEnclosureNumber) {
        this.name = new SimpleStringProperty(name);
        this.master = master;
        this.maxEnclosureNumber = maxEnclosureNumber;
        this.enclosureList = new ArrayList<>();
    }
    public String getName() {
        return name.get();
    }

    // TODO Implement better error handling, requires UI
    public void addEnclosure(Enclosure enclosure) {
        if (maxEnclosureNumber == enclosureList.size()) {
            System.out.println("The max enclosure limit is reached!");
            return;
        }
        this.enclosureList.add(enclosure);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public int getMaxEnclosureNumber() {
        return maxEnclosureNumber;
    }

    public void setMaxEnclosureNumber(int maxEnclosureNumber) {
        this.maxEnclosureNumber = maxEnclosureNumber;
    }

    public ArrayList<Enclosure> getEnclosureList() {
        return enclosureList;
    }

    public void setEnclosureList(ArrayList<Enclosure> enclosureList) {
        this.enclosureList = enclosureList;
    }

    public StringProperty nameProperty() {
        return name;
    }
}
