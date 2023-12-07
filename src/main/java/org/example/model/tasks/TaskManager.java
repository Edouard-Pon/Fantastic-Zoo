package org.example.model.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private List<Thread> threads;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.threads = new ArrayList<>();
    }

    public List<Thread> startTasks(Task... tasks) {
        for (Task task : tasks) {
            createTask(task);
        }
        for (Thread thread : threads) {
            if (!thread.isAlive()) {
                thread.start();
            }
        }
        return threads;
    }

    private void createTask(Task task) {
        tasks.add(task);
        threads.add(new Thread(task));
    }

    public void stopTasks() {
        for (Task task : tasks) {
            task.stop();
        }
    }
}