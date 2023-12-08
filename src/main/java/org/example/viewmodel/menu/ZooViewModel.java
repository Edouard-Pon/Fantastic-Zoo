package org.example.viewmodel.menu;

import org.example.model.data.Data;
import org.example.model.management.Master;
import org.example.model.zoo.FantasticZoo;

public class ZooViewModel {
    public ZooViewModel() {}

    /**
     * Add a new zoo to the zoo list
     * @param zooName
     * @param masterName
     * @param maxEnclosuresNumber
     */
    public void addFantasticZoo(String zooName, String masterName, int maxEnclosuresNumber) {
        Data.getInstance().addFantasticZoo(
                new FantasticZoo(
                        zooName,
                        Data.getInstance().getMaster(masterName),
                        maxEnclosuresNumber
                ));
    }

    /**
     * Get the list of masters
     * @return Iterable<Master>
     */
    public Iterable<Master> getMastersList() {
        return Data.getInstance().getMastersList();
    }
}
