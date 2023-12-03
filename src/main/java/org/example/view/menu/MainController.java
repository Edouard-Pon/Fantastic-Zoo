package org.example.view.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.example.model.data.Data;
import org.example.model.management.Master;
import org.example.model.zoo.FantasticZoo;
import org.example.view.manager.SceneManager;
import javafx.event.ActionEvent;
import org.example.viewmodel.menu.MainViewModel;

public class MainController {
    private MainViewModel mainViewModel;
    @FXML
    private ComboBox<String> cbFantasticZooName;
    @FXML
    private Label lblWarning;

    public MainController() {
        mainViewModel = new MainViewModel();
    }

    @FXML
    public void navButtonsHandler(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            case "btnCreateMaster" -> SceneManager.getInstance().showScene("MasterView");
            case "btnCreateZoo" -> SceneManager.getInstance().showScene("ZooView");
            case "btnStartSimulation" -> {
                setCurrentZoo();
                if (mainViewModel.getCurrentZoo() == null) {
                    lblWarning.setText("Please select a zoo!");
                    break;
                }
                SceneManager.getInstance().showScene("SimulationView");
            }
        }
    }

    @FXML
    public void updateZoosList(MouseEvent event) {
        for (FantasticZoo fantasticZoo : mainViewModel.getFantasticZoosList()) {
            if (cbFantasticZooName.getItems().contains(fantasticZoo.getName())) continue;
            cbFantasticZooName.getItems().add((fantasticZoo).getName());
        }
    }

    private void setCurrentZoo() {
        if (cbFantasticZooName.getValue() == null) {
            lblWarning.setText("Please select a zoo!");
            return;
        }
        mainViewModel.setCurrentZoo(cbFantasticZooName.getValue());
    }
}
