package com.haozi.demo.multithread.basic.uncaughtexception;

/**
 * @className:com.haozi.demo.multithread.basic.uncaughtexception.NoCaughtThread
 * @description:处理非正常的线程终止，不可以使用try catch
 * @version:v1.0.0
 * @date:2016年9月30日 上午9:47:46
 * @author:WangHao
 */
public class NoCaughtThread
{
	public static void main(String[] args)
	{
		// 主方法无法捕获线程中的异常
		try
		{
			Thread thread = new Thread(new Task());
			thread.start();
		} catch (Exception e)
		{
			System.out.println("==Exception: " + e.getMessage());
		}
	}

}

class Task implements Runnable
{
	@Override
	public void run()
	{
		System.out.println(3 / 2);
		System.out.println(3 / 0);
		System.out.println(3 / 1);
	}
}
