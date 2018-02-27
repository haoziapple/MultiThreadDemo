package com.haozi.demo.multithread.model.proNCon;

/**
 * @className:com.haozi.demo.multithread.model.proNCon.ProducerNConsumer
 * @description:生产者消费者模型
 * @version:v1.0.0
 * @date:2016年9月30日 上午11:54:45
 * @author:WangHao
 */
public class ProducerNConsumer
{
	public static int MAX_PRODUCT = 5;

	public static int MIN_PRODUCT = 1;

	private int product;

	/**
	 * 生产者生产出来的产品交给店员
	 */
	public synchronized void produce()
	{
		if (this.product >= MAX_PRODUCT)
		{
			try
			{
				wait();
				System.out.println("产品已满，请稍后再生产");
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			return;
		}

		this.product++;
		System.out.println("生产者生产第" + this.product + "个产品");
		notifyAll();// 通知等待区的消费者可以取出产品了
	}
}
