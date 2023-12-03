package org.example.viewmodel.menu;

import org.example.model.data.Data;
import org.example.model.management.Master;
import org.example.model.zoo.FantasticZoo;

public class ZooViewModel {
    public ZooViewModel() {}

    public void addFantasticZoo(String zooName, String masterName, int maxEnclosuresNumber) {
        Data.getInstance().addFantasticZoo(
                new FantasticZoo(
                        zooName,
                        Data.getInstance().getMaster(masterName),
                        maxEnclosuresNumber
                ));
    }

    public Iterable<Master> getMastersList() {
        return Data.getInstance().getMastersList();
    }
}
