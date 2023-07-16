package com.octopusthu.dev.samples.springboot.scheduledtasks;

public class InfiniteLoop implements Runnable {
    private final String taskName;

    public InfiniteLoop(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        while (true) {
            System.out.printf("Task %s is running...%n", this.taskName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
