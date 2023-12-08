package org.example.view.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.view.manager.SceneManager;
import org.example.viewmodel.menu.MasterViewModel;

public class MasterController {
    private MasterViewModel masterViewModel;
    @FXML
    private TextField txtMasterName;
    @FXML
    private TextField txtMasterAge;
    @FXML
    private ComboBox<String> cbMasterGender;
    @FXML
    private Label lblWarning;

    /**
     * Constructor for MasterController
     */
    public MasterController() {
        masterViewModel = new MasterViewModel();
    }

    /**
     * Navigation buttons handler
     * @param event
     */
    @FXML
    public void navButtonsHandler(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            // TODO add handlers for buttons
            case "btnMainMenu" -> SceneManager.getInstance().showScene("MainView");
            case "btnCreateMaster" -> createMaster();
//            case "btnModifyMaster" -> SceneManager.getInstance().showScene("");
        }
    }

    // TODO add restriction to add only one master with the same name

    /**
     * Create master method
     */
    private void createMaster() {
        if (txtMasterName.getText().isEmpty() || txtMasterAge.getText().isEmpty() || cbMasterGender.getValue() == null) {
            lblWarning.setText("Please fill all the fields!");
            return;
        }
        masterViewModel.addMaster(
                txtMasterName.getText(),
                cbMasterGender.getValue().equals("Male"),
                Integer.parseInt(txtMasterAge.getText())
        );
        lblWarning.setText("Master created successfully! : " + txtMasterName.getText());
        resetAllFields();
    }

    /**
     * Reset all fields method
     */
    private void resetAllFields() {
        txtMasterName.setText("");
        txtMasterAge.setText("");
        cbMasterGender.setValue(null);
    }
}
