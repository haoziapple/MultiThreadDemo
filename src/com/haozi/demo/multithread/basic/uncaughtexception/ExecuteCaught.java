package com.haozi.demo.multithread.basic.uncaughtexception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className:com.haozi.demo.multithread.basic.uncaughtexception.ExecuteCaught
 * @description:线程池中，将异常的捕获封装到Runnable或者Callable中
 * @version:v1.0.0
 * @date:2016年9月30日 上午10:20:18
 * @author:WangHao
 */
public class ExecuteCaught
{
	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ThreadPoolTask());
		exec.shutdown();
	}
}

class ThreadPoolTask implements Runnable
{
	@Override
	public void run()
	{
		Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
		System.out.println(3 / 2);
		System.out.println(3 / 0);
		System.out.println(3 / 1);
	}
}