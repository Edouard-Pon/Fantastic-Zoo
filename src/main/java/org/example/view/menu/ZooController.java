package org.example.view.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.model.data.Data;
import org.example.model.management.Master;
import org.example.model.zoo.FantasticZoo;
import org.example.view.manager.SceneManager;

public class ZooController {
    @FXML
    private ComboBox<String> cbMasterName;
    @FXML
    private TextField txtZooName;
    @FXML
    private TextField txtMaxEnclosuresNumber;
    @FXML
    private Label lblWarning;

    public ZooController() {}

    @FXML
    public void navButtonsHandler(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            // TODO add handlers for buttons
            case "btnMainMenu" -> SceneManager.getInstance().showScene("MainView");
            case "btnCreateZoo" -> createZoo();
//            case "btnModifyZoo" -> SceneManager.getInstance().showScene("");
        }
    }

    @FXML
    public void updateMastersList(MouseEvent event) {
        for (Master master : Data.getInstance().getMastersList()) {
            if (cbMasterName.getItems().contains(master.getName())) continue;
            cbMasterName.getItems().add((master).getName());
        }
    }

    // TODO add restriction to add only one zoo with the same name
    private void createZoo() {
        if (txtZooName.getText().isEmpty() || txtMaxEnclosuresNumber.getText().isEmpty() || cbMasterName.getValue() == null) {
            lblWarning.setText("Please fill all the fields!");
            return;
        }
        Data.getInstance().addFantasticZoo(
                new FantasticZoo(
                        txtZooName.getText(),
                        Data.getInstance().getMaster(cbMasterName.getValue()),
                        Integer.parseInt(txtMaxEnclosuresNumber.getText())
                ));
        lblWarning.setText("Zoo created successfully! : " + txtZooName.getText());
        resetAllFields();
    }

    private void resetAllFields() {
        txtZooName.setText("");
        txtMaxEnclosuresNumber.setText("");
        cbMasterName.setValue(null);
    }
}
