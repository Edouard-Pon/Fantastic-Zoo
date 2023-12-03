package org.example.viewmodel.menu;

import org.example.model.data.Data;
import org.example.model.management.Master;

public class MasterViewModel {
    public MasterViewModel() {}

    public void addMaster(String name, boolean gender, int age) {
        Data.getInstance().addMaster(new Master(name, gender, age));
    }
}
