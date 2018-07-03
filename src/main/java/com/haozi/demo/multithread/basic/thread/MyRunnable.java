package com.haozi.demo.multithread.basic.thread;

public class MyRunnable implements Runnable {
    public MyRunnable() {

    }

    @Override
    public void run() {
        System.out.println("子线程ID: " + Thread.currentThread().getId());
    }

}
