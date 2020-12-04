package com.company;

import java.util.concurrent.BrokenBarrierException;

class CyclicBarrier {
    private final int num_of_needed_elements;
    private int numberWaiting;
    private final Runnable BarAction;
    private boolean broken;

    public CyclicBarrier(int _num_of_needed_elements, Runnable Bar_Action) {
        this.num_of_needed_elements = _num_of_needed_elements;
        this.numberWaiting = _num_of_needed_elements;
        this.BarAction = Bar_Action;
        this.broken = false;
    }

    public synchronized void await() throws InterruptedException, BrokenBarrierException {
        if (this.broken) {
            throw new BrokenBarrierException();
        }

        --this.numberWaiting;

        if (this.numberWaiting > 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                this.broken = true;
                throw e;
            }
        } else {
            this.reset();
            notifyAll();
            if (this.BarAction != null) {
                this.BarAction.run();
            }
        }
    }

    public void reset() {
        this.numberWaiting = this.num_of_needed_elements;
        this.broken = false;
    }

    public int getParties() {
        return this.num_of_needed_elements;
    }
}
