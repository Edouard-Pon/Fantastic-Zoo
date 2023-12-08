package org.example.view.simulation;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.example.view.manager.SceneManager;
import org.example.viewmodel.simulation.SimulationViewModel;

import java.util.Map;

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
    @FXML
    private Pane paneEnclosure;
    @FXML
    private Pane paneCreatureImage;
    @FXML
    private Button btnViewCreature;
    @FXML
    private Label lblCreatureName;
    @FXML
    private Label lblCreatureType;
    @FXML
    private Label lblCreatureGender;
    @FXML
    private Label lblCreatureWeight;
    @FXML
    private Label lblCreatureHeight;
    @FXML
    private Label lblCreatureAge;
    @FXML
    private Label lblCreatureHunger;
    @FXML
    private Label lblCreatureHealth;
    @FXML
    private Label lblCreatureMessage;
    @FXML
    private Label lblEnclosureType;
    @FXML
    private Label lblEnclosureArea;
    @FXML
    private Label lblEnclosureMaxCreatures;
    @FXML
    private Label lblEnclosureHeight;
    @FXML
    private Label lblEnclosureDepth;
    @FXML
    private Label lblEnclosureWaterSalinity;
    @FXML
    private Label lblEnclosureCleanlinessLevel;
    @FXML
    private Label lblEnclosureCreaturesNumber;
    @FXML
    private Label lblEnclosureRoofStatus;
    @FXML
    private Label lblCreatureSleep;
    @FXML
    private TextArea txtLogMessages;
    @FXML
    private Button btnFeedCreature;
    @FXML
    private Label lblCreatureAlive;
    @FXML
    private Button btnHealCreature;

    /**
     * Constructor for the SimulationController
     */
    public SimulationController() {
        viewModel = new SimulationViewModel();
        lstEnclosures = new ListView<>();
    }

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        initBindings();
    }

    /**
     * Initializes the bindings.
     */
    private void initBindings() {
        // TODO remove this if not needed
//        bindLblZooName();
        bindTxtLogMessages();
    }

    /**
     * Updates the data.
     */
    public void updateData() {
        bindLblZooName();
    }

    /**
     * Navigation buttons handler.
     * @param event
     */
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
            case "btnViewEnclosure" -> {
                selectEnclosure();
                showEnclosureStats();
            }
            case "btnRemoveCreature" -> removeCreature();
            case "btnViewCreature" -> {
                showCreature();
                showCreatureStats();
            }
            case "btnRemoveEnclosure" -> {
                if (removeEnclosure()) {
                    clearEnclosureStats();
                    clearCreatureStats();
                    lockCreatureControls();
                }
            }
            case "btnFeedCreature" -> feedCreature();
            case "btnMaintainEnclosure" -> maintainEnclosure();
            case "btnHealCreature" -> healCreature();
        }
    }

    /**
     * Binds the zoo name label.
     */
    private void bindLblZooName() {
        lblZooName.textProperty().bind(viewModel.currentZooNameProperty());
    }

    /**
     * Binds the log messages text area.
     */
    private void bindTxtLogMessages() {
        viewModel.logMessagesProperty().addListener((ListChangeListener.Change<? extends String> change) -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (String item : change.getAddedSubList()) {
                        txtLogMessages.appendText(item + "\n");
                    }
                    updateStats();
                }
            }
        });
    }

    /**
     * Updates the enclosures list.
     */
    public void updateEnclosuresList() {
        ObservableList<String> enclosuresNames = FXCollections.observableArrayList(viewModel.currentZooEnclosuresNamesList());
        lstEnclosures.setItems(enclosuresNames);
        lstEnclosures.refresh();
        clearEnclosureStats();
    }

    /**
     * Updates the creatures list.
     */
    public void updateCreaturesList() {
        ObservableList<String> creaturesNames = FXCollections.observableArrayList(viewModel.currentEnclosureCreaturesNamesList());
        lstCreatures.setItems(creaturesNames);
        lstCreatures.refresh();
        paneCreatureImage.getChildren().clear();
        clearCreatureStats();
    }

    /**
     * Selects an enclosure.
     */
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

    /**
     * Unlocks the creature controls.
     */
    private void unlockCreatureControls() {
        btnPopupAddCreature.setDisable(false);
        btnRemoveCreature.setDisable(false);
        btnViewCreature.setDisable(false);
        btnFeedCreature.setDisable(false);
        btnHealCreature.setDisable(false);
    }

    /**
     * Locks the creature controls.
     */
    private void lockCreatureControls() {
        btnPopupAddCreature.setDisable(true);
        btnRemoveCreature.setDisable(true);
        btnViewCreature.setDisable(true);
        btnFeedCreature.setDisable(true);
        btnHealCreature.setDisable(true);
    }

    /**
     * Clears the fields.
     */
    public void clearFields() {
        lblEnclosureName.setText("");
        lblWarning.setText("");
        lstEnclosures.getItems().clear();
        lstCreatures.getItems().clear();
    }

    /**
     * Removes a creature.
     */
    private void removeCreature() {
        if (lstCreatures.getSelectionModel().getSelectedItem() == null) {
            lblWarning.setText("Please select a creature!");
            return;
        }
        viewModel.removeCreature(lstCreatures.getSelectionModel().getSelectedItem());
        updateCreaturesList();
    }

    /**
     * Removes an enclosure.
     * @return true if the enclosure was removed, false otherwise
     */
    private boolean removeEnclosure() {
        if (lstEnclosures.getSelectionModel().getSelectedItem() == null) {
            lblWarning.setText("Please select an enclosure!");
            return false;
        }
        if (!viewModel.removeEnclosure(lstEnclosures.getSelectionModel().getSelectedItem())) return false;
        updateEnclosuresList();
        return true;
    }

    /**
     * Shows a creature.
     */
    private void showCreature() {
        if (lstCreatures.getSelectionModel().getSelectedItem() == null) {
            lblWarning.setText("Please select a creature!");
            return;
        }
        viewModel.setCurrentCreature(lstCreatures.getSelectionModel().getSelectedItem());

        Image image = viewModel.getCurrentCreatureImage();
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);

        paneCreatureImage.getChildren().clear();
        paneCreatureImage.getChildren().add(imageView);
    }

    /**
     * Shows the creature stats.
     */
    private void showCreatureStats() {
        if (lstCreatures.getSelectionModel().getSelectedItem() == null) {
            lblWarning.setText("Please select a creature!");
            return;
        }
        Map<String, String> stats = viewModel.getCreatureStats(viewModel.getCurrentCreature());

        lblCreatureName.setText("Name: " + stats.get("Name"));
        lblCreatureType.setText("Type: " + stats.get("Type"));
        lblCreatureGender.setText("Gender: " + stats.get("Gender"));
        lblCreatureWeight.setText("Weight: " + stats.get("Weight"));
        lblCreatureHeight.setText("Height: " + stats.get("Height"));
        lblCreatureAge.setText("Age: " + stats.get("Age"));
        lblCreatureHunger.setText("Hunger: " + stats.get("Hunger"));
        lblCreatureHealth.setText("Health: " + stats.get("Health"));
        lblCreatureSleep.setText("Sleep: " + stats.get("Sleep"));
        lblCreatureAlive.setText("Status: " + stats.get("Alive"));
    }

    /**
     * Clears the creature stats.
     */
    private void clearCreatureStats() {
        lblCreatureName.setText("");
        lblCreatureType.setText("");
        lblCreatureGender.setText("");
        lblCreatureWeight.setText("");
        lblCreatureHeight.setText("");
        lblCreatureAge.setText("");
        lblCreatureHunger.setText("");
        lblCreatureHealth.setText("");
        lblCreatureSleep.setText("");
    }

    /**
     * Shows the enclosure stats.
     */
    private void showEnclosureStats() {
        if (lstEnclosures.getSelectionModel().getSelectedItem() == null) {
            lblWarning.setText("Please select an enclosure!");
            return;
        }
        clearEnclosureStats();

        if (viewModel.getCurrentEnclosure() == null) return;

        Map<String, String> stats = viewModel.getEnclosureStats(viewModel.getCurrentEnclosure());

        lblEnclosureType.setText("Type: " + stats.get("Type"));
        lblEnclosureArea.setText("Area: " + stats.get("Area"));
        lblEnclosureMaxCreatures.setText("Max Creatures: " + stats.get("MaxCreaturesNumber"));
        lblEnclosureCreaturesNumber.setText("Creatures Inside: " + stats.get("CreaturesCount"));
        if (stats.get("Type").equals("Aviary")) {
            lblEnclosureHeight.setText("Height: " + stats.get("Height"));
            lblEnclosureRoofStatus.setText("Roof Status: " + stats.get("RoofStatus"));
        }
        if (stats.get("Type").equals("Aquarium")) {
            lblEnclosureDepth.setText("Depth: " + stats.get("Depth"));
            lblEnclosureWaterSalinity.setText("Water Salinity: " + stats.get("WaterSalinity"));
        }
        lblEnclosureCleanlinessLevel.setText("Cleanliness Level: " + stats.get("CleanlinessLevel"));
    }

    /**
     * Clears the enclosure stats.
     */
    private void clearEnclosureStats() {
        lblEnclosureType.setText("");
        lblEnclosureArea.setText("");
        lblEnclosureMaxCreatures.setText("");
        lblEnclosureHeight.setText("");
        lblEnclosureDepth.setText("");
        lblEnclosureWaterSalinity.setText("");
        lblEnclosureCleanlinessLevel.setText("");
        lblEnclosureCreaturesNumber.setText("");
        lblEnclosureRoofStatus.setText("");
    }

    /**
     * Shows a message.
     * @param message the message to be shown
     */
    public void showCreatureMessage(String message) {
        lblCreatureMessage.setText(message);
    }

    /**
     * Clears the creature message.
     */
    public void clearCreatureMessage() {
        lblCreatureMessage.setText("");
    }

    /**
     * Updates the stats.
     */
    public void updateStats() {
        selectEnclosure();
        showEnclosureStats();
        showCreature();
        showCreatureStats();
    }

    /**
     * Feed a creature.
     */
    private void feedCreature() {
        if (lstCreatures.getSelectionModel().getSelectedItem() == null) {
            lblWarning.setText("Please select a creature!");
            return;
        }
        viewModel.feedCreature(lstCreatures.getSelectionModel().getSelectedItem());
        updateStats();
    }

    /**
     * Heal a creature.
     */
    public void healCreature() {
        if (lstCreatures.getSelectionModel().getSelectedItem() == null) {
            lblWarning.setText("Please select a creature!");
            return;
        }
        viewModel.healCreature(lstCreatures.getSelectionModel().getSelectedItem());
        updateStats();
    }

    /**
     * Maintains an enclosure.
     */
    private void maintainEnclosure() {
        if (lstEnclosures.getSelectionModel().getSelectedItem() == null) {
            lblWarning.setText("Please select an enclosure!");
            return;
        }
        viewModel.maintainEnclosure(lstEnclosures.getSelectionModel().getSelectedItem());
        updateStats();
    }
}
