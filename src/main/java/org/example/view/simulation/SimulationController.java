package org.example.view.simulation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.view.manager.SceneManager;
import org.example.viewmodel.simulation.SimulationViewModel;

public class SimulationController {
    private SimulationViewModel viewModel;
    @FXML
    private Label lblWarning;
    @FXML
    private Label lblZooName;
    @FXML
    private ListView<String> lstEnclosures;

    public SimulationController() {
        viewModel = new SimulationViewModel();
        lstEnclosures = new ListView<>();
    }

    public void initialize() {
        initBindings();
    }

    private void initBindings() {
        // TODO remove this if not needed
//        bindLblZooName();
    }

    public void updateData() {
        bindLblZooName();
    }

    @FXML
    public void navButtonsHandler(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            // TODO add handlers for buttons
            case "btnMainMenu" -> SceneManager.getInstance().showScene("MainView");
            case "btnPopupAddEnclosure" -> SceneManager.getInstance().showPopup("AddEnclosureView");
            case "btnAddEnclosure" -> {
//                createEnclosure();
                updateEnclosuresList();
            }
//            case "btnRemoveEnclosure" -> SceneManager.getInstance().showScene("");
//            case "btnMaintain" -> SceneManager.getInstance().showScene("");
//            case "btnViewEnclosure" -> SceneManager.getInstance().showScene("");
        }
    }

    private void bindLblZooName() {
        lblZooName.textProperty().bind(viewModel.currentZooNameProperty());
    }

    public void updateEnclosuresList() {
        ObservableList<String> enclosuresNames = FXCollections.observableArrayList(viewModel.currentZooEnclosuresNamesList());
        lstEnclosures.setItems(enclosuresNames);
        lstEnclosures.refresh();
    }
}
