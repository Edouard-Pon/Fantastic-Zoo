package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.view.manager.SceneManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        SceneManager.getInstance().preloadScene("MainView");
        SceneManager.getInstance().preloadScene("MasterView");
        SceneManager.getInstance().preloadScene("ZooView");
        SceneManager.getInstance().preloadScene("SimulationView");

        SceneManager.getInstance().showScene("MainView");
    }

    public static void main(String[] args) {
        launch();
    }
}