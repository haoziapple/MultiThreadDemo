package com.haozi.demo.multithread.basic.join;

import java.util.Date;

public class Thread4 extends Thread {
    public Thread4(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + " " + getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动子进程
        new Thread4("new thread").start();
        Thread.sleep(6000);
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                Thread4 th = new Thread4("joined thread");
                th.start();
                th.join(); // 等待th执行完才会向下执行
            }
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
