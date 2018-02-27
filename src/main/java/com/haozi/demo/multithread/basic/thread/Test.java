package com.haozi.demo.multithread.basic.thread;

public class Test
{
	public static void main(String[] args)
	{
		System.out.println("主线程ID: " + Thread.currentThread().getId());
		
		MyRunnable runnable = new MyRunnable();
		Thread thread2 = new Thread(runnable);
		thread2.start();

		MyThread thread = new MyThread();
		thread.start();
	}
}
