package com.haozi.demo.multithread.basic.thread;

/**
 * @className:com.haozi.demo.multithread.basic.thread.MyThread
 * @description:Java多线程干货系列（1）：Java多线程基础--例子
 * @version:v1.0.0
 * @date:2016年9月29日 下午1:15:29
 * @author:WangHao
 */
public class MyThread extends Thread {
    private static int num = 0;

    public MyThread() {
        num++;
    }

    @Override
    public void run() {
        System.out.println("主动创建的第" + num + "个线程");
    }
}
