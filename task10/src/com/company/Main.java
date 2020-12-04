package com.company;

public class Main {
    private static final int THREADS = 21;
    private static final int SLEEP_TIME = 1500;
    private static final int NUM_OF_TASKS = 20;

    public static void main(String[] args) {
        try (var executor = new ThreadPool(THREADS)) {
            for (int i = 0; i < NUM_OF_TASKS; ++i) {
                int task = i;
                executor.execute(() -> {
                    try {
                        Thread.sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("Task " + task + " done\n");
                });
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
