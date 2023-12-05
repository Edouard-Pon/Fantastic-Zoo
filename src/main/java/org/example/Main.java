package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.view.manager.DevTools;
import org.example.view.manager.SceneManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        SceneManager.getInstance().preloadScene("MainView");
        SceneManager.getInstance().preloadScene("MasterView");
        SceneManager.getInstance().preloadScene("ZooView");
        SceneManager.getInstance().preloadScene("SimulationView");

        SceneManager.getInstance().showScene("MainView");

        DevTools.getInstance().createMaster();
        DevTools.getInstance().createZoo();
        DevTools.getInstance().setCurrentZoo();
        DevTools.getInstance().createEnclosure();
        DevTools.getInstance().createCreature();
        DevTools.getInstance().createCreature();
        DevTools.getInstance().createCreature();
    }

    public static void main(String[] args) {
        launch();
    }
}