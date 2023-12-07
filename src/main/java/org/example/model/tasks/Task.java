package org.example.model.tasks;

public abstract class Task implements Runnable {
    private volatile boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void stop() {
        isRunning = false;
    }

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

    protected abstract void task() throws InterruptedException;
}
