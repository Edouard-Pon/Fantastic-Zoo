package org.example.model.data;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class DataImages {
    private static DataImages instance = null;
    private final String IMAGE_PATH = "file:src/main/resources/org/example/assets/images/";
    private final String IMAGE_EXTENSION = ".jpeg";
    private final String IMAGE_UNICORN = "unicorn";
    private final String IMAGE_DRAGON = "dragon";
    private final String IMAGE_KRAKEN = "kraken";
    private final String IMAGE_SIREN = "siren";
    private final String IMAGE_NYMPH = "nymph";
    private final String IMAGE_LYCANTHROPE = "lycanthrope";
    private final String IMAGE_PHOENIX = "phoenix";
    private final String IMAGE_MEGALODON = "megalodon";
    private Map<String, Image> imagesMap;

    /**
     * Constructor
     */
    private DataImages() {
        imagesMap = new HashMap<>();
    }

    /**
     * DataImages class
     * @return DataImages instance
     */
    public static DataImages getInstance() {
        if (instance == null) {
            instance = new DataImages();
        }
        return instance;
    }

    /**
     * Load images
     */
    public void loadImages() {
        imagesMap.put(IMAGE_UNICORN, new Image(IMAGE_PATH + IMAGE_UNICORN + IMAGE_EXTENSION));
        imagesMap.put(IMAGE_DRAGON, new Image(IMAGE_PATH + IMAGE_DRAGON + IMAGE_EXTENSION));
        imagesMap.put(IMAGE_KRAKEN, new Image(IMAGE_PATH + IMAGE_KRAKEN + IMAGE_EXTENSION));
        imagesMap.put(IMAGE_SIREN, new Image(IMAGE_PATH + IMAGE_SIREN + IMAGE_EXTENSION));
        imagesMap.put(IMAGE_NYMPH, new Image(IMAGE_PATH + IMAGE_NYMPH + IMAGE_EXTENSION));
        imagesMap.put(IMAGE_LYCANTHROPE, new Image(IMAGE_PATH + IMAGE_LYCANTHROPE + IMAGE_EXTENSION));
        imagesMap.put(IMAGE_PHOENIX, new Image(IMAGE_PATH + IMAGE_PHOENIX + IMAGE_EXTENSION));
        imagesMap.put(IMAGE_MEGALODON, new Image(IMAGE_PATH + IMAGE_MEGALODON + IMAGE_EXTENSION));
    }

    /**
     * Get image
     * @param imageName image name
     * @return image
     */
    public Image getImage(String imageName) {
        return imagesMap.get(imageName);
    }
}
