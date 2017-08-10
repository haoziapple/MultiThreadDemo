package com.haozi.demo.multithread.basic.uncaughtexception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className:com.haozi.demo.multithread.basic.uncaughtexception.ExecuteUnCaught
 * @description:采用线程池通过execute的方法，并未捕获异常
 * @version:v1.0.0
 * @date:2016年9月30日 上午10:16:12
 * @author:WangHao
 */
public class ExecuteUnCaught
{
	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		Thread thread = new Thread(new Task());
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		exec.execute(thread);
		exec.shutdown();
	}
}
