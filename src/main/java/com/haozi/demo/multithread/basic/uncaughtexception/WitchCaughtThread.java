package com.haozi.demo.multithread.basic.uncaughtexception;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * @className:com.haozi.demo.multithread.basic.uncaughtexception.WitchCaughtThread
 * @description:为所有Thread设置一个默认的非受检异常处理器
 * @version:v1.0.0
 * @date:2016年9月30日 上午10:13:24
 * @author:WangHao
 */
public class WitchCaughtThread
{
	public static void main(String args[])
	{
		// 使用Thread的static方法
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
		Thread thread = new Thread(new Task());
		thread.start();
	}
}

class ExceptionHandler implements UncaughtExceptionHandler
{
	@Override
	public void uncaughtException(Thread t, Throwable e)
	{
		System.out.println("==Exception: " + e.getMessage());
	}
}
