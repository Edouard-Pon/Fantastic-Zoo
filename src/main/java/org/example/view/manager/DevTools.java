package org.example.view.manager;

import org.example.model.creatures.Dragon;
import org.example.model.data.Data;
import org.example.model.management.Master;
import org.example.model.spaces.Enclosure;
import org.example.model.zoo.FantasticZoo;

public class DevTools {
    private static DevTools instance = null;

    /**
     * Private constructor for DevTools.
     */
    public DevTools() {}

    /**
     * Get the instance of DevTools.
     * @return DevTools instance.
     */
    public static DevTools getInstance() {
        if (instance == null) {
            instance = new DevTools();
        }
        return instance;
    }

    /**
     * Create a master
     */
    public void createMaster() {
        Data.getInstance().addMaster(new Master("Master Test Name", true, 100));
    }

    /**
     * Create a zoo
     */
    public void createZoo() {
        Master master = Data.getInstance().getMaster("Master Test Name");
        Data.getInstance().addFantasticZoo(new FantasticZoo("Zoo Test Name", master, 3));
    }

    /**
     * Set the current zoo
     */
    public void setCurrentZoo() {
        Data.getInstance().setCurrentZoo(Data.getInstance().getFantasticZoo("Zoo Test Name"));
    }

    /**
     * Create an enclosure
     */
    public void createEnclosure() {
        Data.getInstance().getCurrentZoo().addEnclosure(new Enclosure("Test Enclosure", "Test Area", 10));
    }

    /**
     * Create a creature
     */
    public void createCreature() {
        String creatureNumber = String.valueOf(Data.getInstance().getCurrentZoo().getNumberOfCreatures());
        Data.getInstance().getCurrentZoo().getEnclosureByName("Test Enclosure").addCreatures(new Dragon("Dragon Test Name " + creatureNumber, true, 1, 2, 0));
    }
}
