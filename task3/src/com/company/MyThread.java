package com.company;

public class MyThread implements Runnable{
    public int time;

    MyThread(int time){
        this.time = time;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
