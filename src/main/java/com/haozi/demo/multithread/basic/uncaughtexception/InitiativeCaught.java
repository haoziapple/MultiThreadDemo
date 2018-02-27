package com.haozi.demo.multithread.basic.uncaughtexception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className:com.haozi.demo.multithread.basic.uncaughtexception.InitiativeCaught
 * @description:主动捕获线程内部的未检测异常
 * @version:v1.0.0
 * @date:2016年9月30日 上午10:08:22
 * @author:WangHao
 */
public class InitiativeCaught
{
	public void threadDeal(Runnable r, Throwable t)
	{
		System.out.println("==Exception" + t.getMessage());
	}

	class InitiativeThread implements Runnable
	{
		@Override
		public void run()
		{
			Throwable thrown = null;
			try
			{
				System.out.println(3 / 2);
				System.out.println(3 / 0);
				System.out.println(3 / 1);
			} catch (Throwable e)
			{
				thrown = e;
			} finally
			{
				threadDeal(this, thrown);
			}
		}
	}

	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new InitiativeCaught().new InitiativeThread());
		exec.shutdown();
	}
}
