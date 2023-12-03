package org.example.view.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.view.manager.SceneManager;
import javafx.event.ActionEvent;

public class MainController {
    public MainController() {}

    @FXML
    public void navButtonsHandler(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            case "btnCreateMaster" -> SceneManager.getInstance().showScene("MasterView");
            case "btnCreateZoo" -> SceneManager.getInstance().showScene("ZooView");
            case "btnStartSimulation" -> SceneManager.getInstance().showScene("SimulationView");
        }
    }
}
