package org.example.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FantasticZoo {
    private String name;
    private String masterName;//TODO replace by Master class
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
    public FantasticZoo(String name, String masterName, int maxEnclosureNumber) {
        this.name = name;
        this.masterName = masterName;
        this.maxEnclosureNumber = maxEnclosureNumber;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
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
}
