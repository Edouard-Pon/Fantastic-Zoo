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
    @FXML
    private Button btnPopupAddCreature;
    @FXML
    private ListView<String> lstCreatures;
    @FXML
    private Label lblEnclosureName;
    @FXML
    private Button btnRemoveCreature;

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
            case "btnMainMenu" -> {
                viewModel.setCurrentEnclosure(null);
                viewModel.setCurrentZoo(null);
                clearFields();
                lockCreatureControls();
                SceneManager.getInstance().showScene("MainView");
            }
            case "btnPopupAddEnclosure" -> SceneManager.getInstance().showPopup("AddEnclosureView");
            case "btnPopupAddCreature" -> SceneManager.getInstance().showPopup("AddCreatureView");
            case "btnViewEnclosure" -> selectEnclosure();
            case "btnRemoveCreature" -> removeCreature();
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

    public void updateCreaturesList() {
        ObservableList<String> creaturesNames = FXCollections.observableArrayList(viewModel.currentEnclosureCreaturesNamesList());
        lstCreatures.setItems(creaturesNames);
        lstCreatures.refresh();
    }

    private void selectEnclosure() {
        viewModel.setCurrentEnclosure(lstEnclosures.getSelectionModel().getSelectedItem());
        if (viewModel.getCurrentEnclosure() == null) {
            lblWarning.setText("Please select an enclosure!");
            return;
        }
        lblEnclosureName.setText(viewModel.getCurrentEnclosure().getName());
        unlockCreatureControls();
        updateCreaturesList();
    }

    private void unlockCreatureControls() {
        btnPopupAddCreature.setDisable(false);
        btnRemoveCreature.setDisable(false);
    }

    private void lockCreatureControls() {
        btnPopupAddCreature.setDisable(true);
        btnRemoveCreature.setDisable(true);
    }

    public void clearFields() {
        lblEnclosureName.setText("");
        lblWarning.setText("");
        lstEnclosures.getItems().clear();
        lstCreatures.getItems().clear();
    }

    public void removeCreature() {
        viewModel.removeCreature(lstCreatures.getSelectionModel().getSelectedItem());
        updateCreaturesList();
    }
}
