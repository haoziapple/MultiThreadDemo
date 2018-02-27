package com.haozi.demo.multithread.basic.uncaughtexception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @className:com.haozi.demo.multithread.basic.uncaughtexception.SubmitCaught
 * @description:submit提交任务,无论是抛出的未检测异常还是已检查异常，都将被认为是任务返回状态的一部分
 * @version:v1.0.0
 * @date:2016年9月30日 上午10:36:50
 * @author:WangHao
 */
public class SubmitCaught
{
	public static void main(String[] args)
	{
		// ExecutorService exec = Executors.newCachedThreadPool();
		// exec.submit(new Task());
		// exec.submit(new ThreadPoolTask());
		// exec.shutdown();

		ExecutorService exec = Executors.newCachedThreadPool();
		Future<?> future = exec.submit(new Task());
		exec.shutdown();
		try
		{
			future.get();
		} catch (Exception e)
		{
			System.out.println("==Exception: " + e.getMessage());
		}
	}
}
