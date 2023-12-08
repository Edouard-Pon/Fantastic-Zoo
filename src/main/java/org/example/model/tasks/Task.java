package org.example.model.tasks;

public abstract class Task implements Runnable {
    private volatile boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Stop the task.
     */
    public void stop() {
        isRunning = false;
    }

    /**
     * Run the task.
     */
    @Override
    public void run() {
        while (isRunning) {
            try {
                task();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The task to be executed.
     *
     * @throws InterruptedException if the thread is interrupted
     */
    protected abstract void task() throws InterruptedException;
}
