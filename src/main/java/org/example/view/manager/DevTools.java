package org.example.view.manager;

import org.example.model.data.Data;
import org.example.model.management.Master;
import org.example.model.zoo.FantasticZoo;

public class DevTools {
    private static DevTools instance = null;

    public DevTools() {}

    public static DevTools getInstance() {
        if (instance == null) {
            instance = new DevTools();
        }
        return instance;
    }

    public void createMaster() {
        Data.getInstance().addMaster(new Master("Master Test Name", true, 100));
    }

    public void createZoo() {
        Master master = Data.getInstance().getMaster("Master Test Name");
        Data.getInstance().addFantasticZoo(new FantasticZoo("Zoo Test Name", master, 3));
    }
}
