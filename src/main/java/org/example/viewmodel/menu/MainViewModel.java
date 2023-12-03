package org.example.viewmodel.menu;

import org.example.model.data.Data;
import org.example.model.zoo.FantasticZoo;

public class MainViewModel {
    public MainViewModel() {}

    public void setCurrentZoo(String zooName) {
         Data.getInstance().setCurrentZoo(Data.getInstance().getFantasticZoo(zooName));
    }

    public FantasticZoo getCurrentZoo() {
        return Data.getInstance().getCurrentZoo();
    }

    public Iterable<FantasticZoo> getFantasticZoosList() {
        return Data.getInstance().getFantasticZoosList();
    }
}
