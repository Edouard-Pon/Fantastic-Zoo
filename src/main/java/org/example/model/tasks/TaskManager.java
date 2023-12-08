package org.example.model.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private List<Thread> threads;

    /**
     * Creates a new TaskManager.
     */
    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.threads = new ArrayList<>();
    }

    /**
     * Starts the given tasks.
     *
     * @param tasks the tasks to start
     * @return the threads that were started
     */
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

    /**
     * Creates a task and adds it to the list of tasks.
     *
     * @param task the task to create
     */
    private void createTask(Task task) {
        tasks.add(task);
        threads.add(new Thread(task));
    }

    /**
     * Stops all tasks.
     */
    public void stopTasks() {
        for (Task task : tasks) {
            task.stop();
        }
    }

    /**
     * Clears all tasks.
     */
    public void clearTasks() {
        tasks.clear();
        threads.clear();
    }
}