package org.example.view.manager;

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
    private Map<String, Object> controllers;

    /**
     * Constructor for SceneManager
     */
    private SceneManager() {
        stage = new Stage();
        scenes = new HashMap<>();
        controllers = new HashMap<>();
    }

    /**
     * Get the instance of SceneManager
     * @return SceneManager
     */
    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    /**
     * Preload a scene
     * @param fileName
     */
    public void preloadScene(String fileName) {
        try {
            String resourcePath = "/org/example/fxml/" + fileName + ".fxml";
            URL resourceUrl = getClass().getResource(resourcePath);

            if (resourceUrl != null) {
                FXMLLoader loader = new FXMLLoader(resourceUrl);
                Parent root = loader.load();
                Scene scene = new Scene(root);

                Object controller = loader.getController();
                controllers.put(fileName, controller);

                scenes.put(fileName, scene);
            } else {
                System.out.println("Resource not found: " + resourcePath);
            }
        } catch (Exception e) {
            System.out.println("Error loading scene " + fileName);
            e.printStackTrace();
        }
    }

    /**
     * Show a scene
     * @param fileName
     */
    public void showScene(String fileName) {
        if (!scenes.containsKey(fileName)) {
            preloadScene(fileName);
        } else if (scenes.get(fileName) == null) {
            System.err.println("Scene " + fileName + " is not loaded");
        }
        stage.setScene(scenes.get(fileName));
        stage.show();

        Object controller = controllers.get(fileName);
        if (controller != null) {
            try {
                controller.getClass().getMethod("updateData").invoke(controller);
            } catch (NoSuchMethodException e) {
                System.err.println("No updateData method found for controller " + controller.getClass().getName());
            } catch (Exception e) {
                System.err.println("Error updating data for controller " + controller.getClass().getName());
                e.printStackTrace();
            }
        }
    }

    /**
     * Show a popup
     * @param fileName
     */
    public void showPopup(String fileName) {
        if (!scenes.containsKey(fileName)) {
            preloadScene(fileName);
        } else if (scenes.get(fileName) == null) {
            System.err.println("Scene " + fileName + " is not loaded");
        }
        Stage popUpStage = new Stage();
        popUpStage.setScene(scenes.get(fileName));
        popUpStage.show();
    }

    /**
     * Close a popup
     * @param fileName
     */
    public void closePopup(String fileName) {
        if (!scenes.containsKey(fileName)) {
            System.err.println("Scene " + fileName + " is not loaded");
        } else {
            Stage popUpStage = (Stage) scenes.get(fileName).getWindow();
            popUpStage.close();
        }
    }

    /**
     * Close a scene
     * @param fileName
     */
    public void closeScene(String fileName) {
        if (!scenes.containsKey(fileName)) {
            System.err.println("Scene " + fileName + " is not loaded");
        } else {
            Stage popUpStage = (Stage) scenes.get(fileName).getWindow();
            popUpStage.close();
        }
    }

    /**
     * Get the controller of a scene
     * @param fileName
     * @return Object
     */
    public Object getController(String fileName) {
        return controllers.get(fileName);
    }
}
