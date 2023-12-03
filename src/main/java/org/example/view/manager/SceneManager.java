package org.example.view.manager;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class SceneManager {
    private static SceneManager instance = null;
    private Stage stage;
    private Map<String, Scene> scenes;

    private SceneManager() {
        stage = new Stage();
        scenes = new HashMap<>();
    }

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public void preloadScene(String fileName) {
        try {
            String resourcePath = "/org/example/fxml/" + fileName + ".fxml";
            URL resourceUrl = getClass().getResource(resourcePath);

            if (resourceUrl != null) {
                FXMLLoader loader = new FXMLLoader(resourceUrl);
                Parent root = loader.load();
                Scene scene = new Scene(root);
                scenes.put(fileName, scene);
            } else {
                System.out.println("Resource not found: " + resourcePath);
            }
        } catch (Exception e) {
            System.out.println("Error loading scene " + fileName);
            e.printStackTrace();
        }
    }

    public void showScene(String fileName) {
        if (!scenes.containsKey(fileName)) {
            preloadScene(fileName);
        } else if (scenes.get(fileName) == null) {
            System.err.println("Scene " + fileName + " is not loaded");
        }
        stage.setScene(scenes.get(fileName));
        stage.show();
    }
}
