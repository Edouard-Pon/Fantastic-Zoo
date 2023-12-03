package org.example.view.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.view.manager.SceneManager;

public class ZooController {
    public ZooController() {}

    @FXML
    public void navButtonsHandler(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            // TODO add handlers for buttons
            case "btnMainMenu" -> SceneManager.getInstance().showScene("MainView");
//            case "btnCreateZoo" -> SceneManager.getInstance().showScene("");
//            case "btnModifyZoo" -> SceneManager.getInstance().showScene("");
        }
    }
}
