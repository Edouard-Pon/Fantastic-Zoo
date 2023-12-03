package org.example.view.simulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.model.data.Data;
import org.example.view.manager.SceneManager;

public class SimulationController {
    @FXML
    private Label lblWarning;
    @FXML
    private Label lblZooName;

    public SimulationController() {}

    public void initialize() {
        initBindings();
    }

    private void initBindings() {
        // TODO remove this if not needed
//        bindLblZooName();
    }

    @FXML
    public void navButtonsHandler(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            // TODO add handlers for buttons
            case "btnMainMenu" -> SceneManager.getInstance().showScene("MainView");
//            case "btnAddEnclosure" -> SceneManager.getInstance().showScene("");
//            case "btnRemoveEnclosure" -> SceneManager.getInstance().showScene("");
//            case "btnMaintain" -> SceneManager.getInstance().showScene("");
//            case "btnViewEnclosure" -> SceneManager.getInstance().showScene("");
        }
    }

    private void bindLblZooName() {
        lblZooName.textProperty().bind(Data.getInstance().getCurrentZoo().nameProperty());
    }

    public void updateData() {
        bindLblZooName();
    }
}