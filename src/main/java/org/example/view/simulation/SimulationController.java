package org.example.view.simulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.model.data.Data;
import org.example.view.manager.SceneManager;
import org.example.viewmodel.simulation.SimulationViewModel;

public class SimulationController {
    private SimulationViewModel viewModel;
    @FXML
    private Label lblWarning;
    @FXML
    private Label lblZooName;
    @FXML
    private TextField txtEnclosureName;
    @FXML
    private TextField txtEnclosureArea;
    @FXML
    private TextField txtEnclosureMaxCreatures;
    @FXML
    private TextField txtEnclosureHeight;
    @FXML
    private TextField txtEnclosureDepth;
    @FXML
    private TextField txtEnclosureWaterSalinity;
    @FXML
    private ComboBox<String> cmbEnclosureType;

    public SimulationController() {
        viewModel = new SimulationViewModel();
    }

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
            case "btnPopupAddEnclosure" -> SceneManager.getInstance().showPopup("AddEnclosureView");
//            case "btnAddEnclosure" -> ;
//            case "btnRemoveEnclosure" -> SceneManager.getInstance().showScene("");
//            case "btnMaintain" -> SceneManager.getInstance().showScene("");
//            case "btnViewEnclosure" -> SceneManager.getInstance().showScene("");
        }
    }

    private void bindLblZooName() {
        lblZooName.textProperty().bind(viewModel.currentZooNameProperty());
    }

    @FXML
    public void handleEnclosureType(ActionEvent event) {
        switch (cmbEnclosureType.getValue()) {
            case "Aquarium" -> {
                txtEnclosureWaterSalinity.setDisable(false);
                txtEnclosureDepth.setDisable(false);
                txtEnclosureHeight.setDisable(true);
                txtEnclosureHeight.setText("");
            }
            case "Aviary" -> {
                txtEnclosureHeight.setDisable(false);
                txtEnclosureWaterSalinity.setDisable(true);
                txtEnclosureDepth.setDisable(true);
                txtEnclosureWaterSalinity.setText("");
                txtEnclosureDepth.setText("");
            }
            case "Default" -> {
                txtEnclosureWaterSalinity.setDisable(true);
                txtEnclosureHeight.setDisable(true);
                txtEnclosureDepth.setDisable(true);
                txtEnclosureWaterSalinity.setText("");
                txtEnclosureHeight.setText("");
                txtEnclosureDepth.setText("");
            }
        }
    }

    public void updateData() {
        bindLblZooName();
    }
}
