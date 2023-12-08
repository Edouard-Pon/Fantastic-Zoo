package org.example.viewmodel.menu;

import org.example.model.data.Data;
import org.example.model.zoo.FantasticZoo;

public class MainViewModel {
    public MainViewModel() {}

    /**
     * Sets the current zoo to the zoo with the given name
     * @param zooName
     */
    public void setCurrentZoo(String zooName) {
         Data.getInstance().setCurrentZoo(Data.getInstance().getFantasticZoo(zooName));
    }

    /**
     * Returns the current zoo
     * @return
     */
    public FantasticZoo getCurrentZoo() {
        return Data.getInstance().getCurrentZoo();
    }

    /**
     * Returns the list of zoos
     * @return
     */
    public Iterable<FantasticZoo> getFantasticZoosList() {
        return Data.getInstance().getFantasticZoosList();
    }
}
