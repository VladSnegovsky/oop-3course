package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;


public class ThreadPool implements Executor, AutoCloseable {
    private final Queue<Runnable> workQueue;
    private final List<Thread> threads;
    private volatile boolean isRunning;

    private void startThreadPool(int nThreads) {
        for (int i = 0; i < nThreads; i++) {
            var thread = new Thread(() -> {
                while (!this.isRunning || this.workQueue.size() > 0) {
                    Runnable nextTask = this.workQueue.poll();
                    if (nextTask != null) {
                        nextTask.run();
                    }
                }
            });

            threads.add(thread);
            thread.start();
        }
    }

    public ThreadPool(int nThreads) {
        this.workQueue = new ConcurrentLinkedQueue<>();
        this.threads = new ArrayList<>(nThreads);
        this.isRunning = false;

        this.startThreadPool(nThreads);
    }

    @Override
    public void execute(Runnable command) {
        if (!this.isRunning) {
            this.workQueue.offer(command);
        }
    }

    @Override
    public void close() throws InterruptedException {
        this.isRunning = true;

        for (Thread thread: threads) {
            thread.join();
        }
    }
}