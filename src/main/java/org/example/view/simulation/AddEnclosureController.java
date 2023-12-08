package org.example.view.simulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.view.manager.SceneManager;
import org.example.viewmodel.simulation.SimulationViewModel;

public class AddEnclosureController {
    private SimulationViewModel viewModel;
    @FXML
    private Label lblWarning;
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

    /**
     * Constructor for AddEnclosureController.
     */
    public AddEnclosureController() {
        viewModel = new SimulationViewModel();
    }

    /**
     * Navigation buttons handler.
     * @param event
     */
    @FXML
    public void navButtonsHandler(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            case "btnAddEnclosure" -> {
                createEnclosure();
                Object controller = SceneManager.getInstance().getController("SimulationView");
                if (controller != null) {
                    try {
                        controller.getClass().getMethod("updateEnclosuresList").invoke(controller);
                    } catch (NoSuchMethodException e) {
                        System.err.println("No updateEnclosuresList method found for controller " + controller.getClass().getName());
                    } catch (Exception e) {
                        System.err.println("Error updating data for controller " + controller.getClass().getName());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Enclosure type handler.
     * @param event
     */
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

    /**
     * Creates an enclosure.
     */
    private void createEnclosure() {
        String name = txtEnclosureName.getText();
        String type = cmbEnclosureType.getValue();
        String area = txtEnclosureArea.getText();
        String maxCreatures = txtEnclosureMaxCreatures.getText();
        String height = txtEnclosureHeight.getText();
        String depth = txtEnclosureDepth.getText();
        String waterSalinity = txtEnclosureWaterSalinity.getText();

        if (viewModel.hasEnclosure(name)) {
            lblWarning.setText("Enclosure already exists");
            return;
        }

        if (viewModel.createEnclosure(name, type, area, maxCreatures, height, depth, waterSalinity)) {
            clearFields();
            SceneManager.getInstance().closePopup("AddEnclosureView");
        } else {
            lblWarning.setText("Please fill in all the fields");
        }
    }

    /**
     * Clears all the fields.
     */
    private void clearFields() {
        txtEnclosureName.setText("");
        txtEnclosureArea.setText("");
        txtEnclosureMaxCreatures.setText("");
        txtEnclosureHeight.setText("");
        txtEnclosureDepth.setText("");
        txtEnclosureWaterSalinity.setText("");
        cmbEnclosureType.setValue("Default");
        lblWarning.setText("");
    }
}
