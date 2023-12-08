package org.example.view.simulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.example.view.manager.SceneManager;
import org.example.viewmodel.simulation.SimulationViewModel;

public class AddCreatureController {
    private SimulationViewModel viewModel;
    @FXML
    private Label lblWarning;
    @FXML
    private ComboBox<String> cbCreatureType;
    @FXML
    private TextField txtCreatureName;
    @FXML
    private ComboBox<String> cbCreatureGender;
    @FXML
    private TextField txtCreatureWeight;
    @FXML
    private TextField txtCreatureHeight;
    @FXML
    private TextField txtCreatureAge;
    @FXML
    private ComboBox<String> cbCreatureEnclosure;

    /**
     * Constructor for AddCreatureController
     */
    public AddCreatureController() {
        viewModel = new SimulationViewModel();
    }

    /**
     * Navigation buttons handler
     * @param event
     */
    @FXML
    public void navButtonsHandler(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            case "btnAddCreature" -> {
                createCreature();
                Object controller = SceneManager.getInstance().getController("SimulationView");
                if (controller != null) {
                    try {
                        controller.getClass().getMethod("updateCreaturesList").invoke(controller);
                    } catch (NoSuchMethodException e) {
                        System.err.println("No updateCreaturesList method found for controller " + controller.getClass().getName());
                    } catch (Exception e) {
                        System.err.println("Error updating data for controller " + controller.getClass().getName());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Create creature
     */
    private void createCreature() {
        String creatureType = cbCreatureType.getValue();
        String creatureName = txtCreatureName.getText();
        String creatureGender = cbCreatureGender.getValue();
        String creatureWeight = txtCreatureWeight.getText();
        String creatureHeight = txtCreatureHeight.getText();
        String creatureAge = txtCreatureAge.getText();
        String creatureEnclosure = cbCreatureEnclosure.getValue();

        if (viewModel.hasCreature(creatureName, creatureEnclosure)) {
            lblWarning.setText("Creature already exists");
            return;
        }

        if (viewModel.createCreature(creatureType, creatureName, creatureGender, creatureWeight, creatureHeight, creatureAge, creatureEnclosure)) {
            clearFields();
            SceneManager.getInstance().closePopup("AddCreatureView");
        } else {
            lblWarning.setText("Please fill in all the fields");
        }
    }

    /**
     * Clear fields
     */
    private void clearFields() {
        cbCreatureType.setValue(null);
        txtCreatureName.setText("");
        cbCreatureGender.setValue(null);
        txtCreatureWeight.setText("");
        txtCreatureHeight.setText("");
        txtCreatureAge.setText("");
        lblWarning.setText("");
        cbCreatureEnclosure.setValue(null);
    }

    /**
     * Update enclosures list
     * @param event
     */
    @FXML
    public void updateEnclosuresList(MouseEvent event) {
        cbCreatureEnclosure.getItems().clear();
        cbCreatureEnclosure.getItems().addAll(viewModel.currentZooEnclosuresNamesList());
    }
}
