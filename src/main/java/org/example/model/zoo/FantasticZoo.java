package org.example.model.zoo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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

    /**
     * Returns the number of creatures in the zoo
     * @return
     */
    public AtomicInteger getNumberOfCreatures(){
        AtomicInteger number = new AtomicInteger();
        enclosureList.forEach((enclosure) -> number.getAndAdd(enclosure.getNumberOfCreatures()));
        return number;
    }

    /**
     * Returns the number of creatures in the zoo
     * @return
     */
    public ArrayList<Creature> getAllCreatures(){
        ArrayList<Creature> creatures = new ArrayList<Creature>();
        enclosureList.forEach((enclosure) -> creatures.addAll(enclosure.getCreaturesList()));
        return creatures;
    }

    /**
     * Constructor for FantasticZoo
     * @param name
     * @param master
     * @param maxEnclosureNumber
     */
    public FantasticZoo(String name, Master master, int maxEnclosureNumber) {
        this.name = new SimpleStringProperty(name);
        this.master = master;
        this.maxEnclosureNumber = maxEnclosureNumber;
        this.enclosureList = new ArrayList<>();
    }

    /**
     * Returns the name of the zoo
     * @return name
     */
    public String getName() {
        return name.get();
    }

    // TODO Implement better error handling, requires UI

    /**
     * Adds an enclosure to the zoo
     * @param enclosure
     */
    public void addEnclosure(Enclosure enclosure) {
        if (maxEnclosureNumber == enclosureList.size()) {
            System.out.println("The max enclosure limit is reached!");
            return;
        }
        this.enclosureList.add(enclosure);
    }

    /**
     * Removes an enclosure from the zoo
     * @param enclosure
     * @return true if the enclosure was removed, false otherwise
     */
    public boolean removeEnclosure(Enclosure enclosure) {
        if (enclosureList.isEmpty()) {
            System.out.println("There are no enclosures!");
            return false;
        }
        if (enclosure.getNumberOfCreatures() != 0) {
            System.out.println("The enclosure is not empty!");
            return false;
        }
        this.enclosureList.remove(enclosure);
        return true;
    }

    /**
     * Sets the name of the zoo
     * @param name
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * Returns the master of the zoo
     * @return master
     */
    public Master getMaster() {
        return master;
    }

    /**
     * Sets the master of the zoo
     * @param master
     */
    public void setMaster(Master master) {
        this.master = master;
    }

    /**
     * Returns the maximum number of enclosures
     * @return maxEnclosureNumber
     */
    public int getMaxEnclosureNumber() {
        return maxEnclosureNumber;
    }

    /**
     * Sets the maximum number of enclosures
     * @param maxEnclosureNumber
     */
    public void setMaxEnclosureNumber(int maxEnclosureNumber) {
        this.maxEnclosureNumber = maxEnclosureNumber;
    }

    /**
     * Returns the list of enclosures
     * @return enclosureList
     */
    public ArrayList<Enclosure> getEnclosureList() {
        return enclosureList;
    }

    /**
     * Returns an enclosure by name
     * @param name
     * @return enclosure
     */
    public Enclosure getEnclosureByName(String name) {
        for (Enclosure enclosure : enclosureList) {
            if (enclosure.getName().equals(name)) return enclosure;
        }
        return null;
    }

    /**
     * Sets the list of enclosures
     * @param enclosureList
     */
    public void setEnclosureList(ArrayList<Enclosure> enclosureList) {
        this.enclosureList = enclosureList;
    }

    /**
     * Returns the name property of the zoo
     * @return name
     */
    public StringProperty nameProperty() {
        return name;
    }
}
