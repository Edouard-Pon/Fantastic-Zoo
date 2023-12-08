package org.example.model.tasks.creatures;

import javafx.application.Platform;
import org.example.model.creatures.Creature;
import org.example.model.data.Data;
import org.example.model.tasks.Task;
import org.example.view.manager.SceneManager;

public class Aging extends Task {
    private Creature creature;

    /**
     * Aging task constructor
     * @param creature Creature to age
     */
    public Aging(Creature creature) {
        this.creature = creature;
    }

    /**
     * Aging task
     * @throws InterruptedException
     */
    @Override
    protected void task() throws InterruptedException {
        Thread.sleep(10000);
        creature.setAge(creature.getAge() + 1);
        // TODO Remove if not needed or uncomment if needed
//        Platform.runLater(() -> Data.getInstance().addLogMessage(creature.getName() + " is now " + creature.getAge() + " years old."));
        if (super.isRunning()) {
            Platform.runLater(() -> {
                Object controller = SceneManager.getInstance().getController("SimulationView");
                if (controller != null) {
                    try {
                        controller.getClass().getMethod("updateStats").invoke(controller);
                    } catch (NoSuchMethodException e) {
                        System.err.println("No updateStats method found for controller " + controller.getClass().getName());
                    } catch (Exception e) {
                        System.err.println("Error updating stats for controller " + controller.getClass().getName());
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
