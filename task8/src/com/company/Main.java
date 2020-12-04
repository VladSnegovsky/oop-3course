package com.company;

public class Main {
    private static int NUMOFITERATIONS = 100000;
    private static volatile int counter = 0;
    private static boolean locked = true;
    private static ReentrantLock Reentrant_Lock = new ReentrantLock();

    private static Runnable changeCount(int value, String name) {
        return locked ? () -> {
            for (int i = 0; i < NUMOFITERATIONS; ++i) {
                Reentrant_Lock.lock();
                System.out.println(name);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter += value;
                Reentrant_Lock.unlock();
            }
        } : () -> {
            for (int i = 0; i < NUMOFITERATIONS; ++i) {
                counter += value;
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(changeCount(1, "First"));
        Thread thread2 = new Thread(changeCount(-1, "Second"));

        thread1.setName("First");
        thread1.setName("Second");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}
