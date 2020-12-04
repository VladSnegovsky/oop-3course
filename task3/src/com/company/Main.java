package com.company;

public class Main{
    public static void main(String[] args) throws InterruptedException {
        //Creating Groups
        ThreadGroup group1 = new ThreadGroup("1");
        ThreadGroup group2 = new ThreadGroup(group1, "2");
//        ThreadGroup group3 = new ThreadGroup("3");
//        ThreadGroup group4 = new ThreadGroup("4");



        //Starting Threads
        new Thread(group1, new MyThread(2000)).start();
        new Thread(group1, new MyThread(3000)).start();
        new Thread(group2, new MyThread(4000)).start();
//        new Thread(group2, new MyThread(5000)).start();
//        new Thread(group2, new MyThread(6000)).start();
//        new Thread(group3, new MyThread(7000)).start();
//        new Thread(group3, new MyThread(7000)).start();
//        new Thread(group4, new MyThread(9000)).start();
//        new Thread(group4, new MyThread(2000)).start();
//        new Thread(group4, new MyThread(5000)).start();

        //Showing results
        ShowThreads.showallThreads(group1);
        ShowThreads.showallThreads(group2);
//        ShowThreads.showallThreads(group3);
//        ShowThreads.showallThreads(group4);
    }
}
