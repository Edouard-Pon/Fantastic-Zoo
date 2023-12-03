package org.example.view.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.example.model.data.Data;
import org.example.model.management.Master;
import org.example.model.zoo.FantasticZoo;
import org.example.view.manager.SceneManager;
import javafx.event.ActionEvent;

public class MainController {
    @FXML
    private ComboBox<String> cbFantasticZooName;
    @FXML
    private Label lblWarning;

    public MainController() {}

    @FXML
    public void navButtonsHandler(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            case "btnCreateMaster" -> SceneManager.getInstance().showScene("MasterView");
            case "btnCreateZoo" -> SceneManager.getInstance().showScene("ZooView");
            case "btnStartSimulation" -> {
                setCurrentZoo();
                if (Data.getInstance().getCurrentZoo() == null) {
                    lblWarning.setText("Please select a zoo!");
                    break;
                }
                SceneManager.getInstance().showScene("SimulationView");
            }
        }
    }

    @FXML
    public void updateZoosList(MouseEvent event) {
        for (FantasticZoo fantasticZoo : Data.getInstance().getFantasticZoosList()) {
            if (cbFantasticZooName.getItems().contains(fantasticZoo.getName())) continue;
            cbFantasticZooName.getItems().add((fantasticZoo).getName());
        }
    }

    private void setCurrentZoo() {
        if (cbFantasticZooName.getValue() == null) {
            lblWarning.setText("Please select a zoo!");
            return;
        }
        Data.getInstance().setCurrentZoo(Data.getInstance().getFantasticZoo(cbFantasticZooName.getValue()));
    }
}
