package com.haozi.demo.multithread.model.proNCon;

/**
 * @className:com.haozi.demo.multithread.model.proNCon.Godown
 * @description:仓库
 * @version:v1.0.0
 * @date:2016年9月30日 下午1:07:56
 * @author:WangHao
 */
public class Godown
{
	// 1、生产者仅仅在仓储未满时候生产，仓满则停止生产。
	// 2、消费者仅仅在仓储有产品时候才能消费，仓空则等待。
	// 3、当消费者发现仓储没产品可消费时候会通知生产者生产。
	// 4、生产者在生产出可消费产品时候，应该通知等待的消费者去消费。

	public static final int max_size = 100; // 最大库存量
	public int curnum; // 当前库存量

	Godown()
	{

	}

	Godown(int curnnum)
	{
		this.curnum = curnnum;
	}

	/**
	 * 生产指定数量的产品
	 */
	public synchronized void produce(int neednum)
	{
		// 测试是否需要生产
		while (neednum + curnum > max_size)
		{
			System.out.println("要生产的产品数量" + neednum + "超过剩余库存量" + (max_size - curnum) + "，暂时不能执行生产任务!");
			try
			{
				// 当前的生产线程等待
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		// 满足生产条件，则进行生产，这里简单的更改当前库存量
		curnum += neednum;
		System.out.println("已经生产了" + neednum + "个产品，现仓储量为" + curnum);
		// 唤醒在此对象监视器上等待的所有线程
		notifyAll();
	}

	/**
	 * 消费指定数量的产品
	 * 
	 * @param neednum
	 */
	public synchronized void consume(int neednum)
	{
		// 测试是否可消费
		while (curnum < neednum)
		{
			try
			{
				// 当前的生产线程等待
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		// 满足消费条件，则进行消费，这里简单的更改当前库存量
		curnum -= neednum;
		System.out.println("已经消费了" + neednum + "个产品，现仓储量为" + curnum);
		// 唤醒在此对象监视器上等待的所有线程
		notifyAll();
	}

	public static void main(String[] args)
	{
		Godown godown = new Godown(30);
		Consumer c1 = new Consumer(50, godown);
		Consumer c2 = new Consumer(20, godown);
		Consumer c3 = new Consumer(30, godown);
		Producer p1 = new Producer(10, godown);
		Producer p2 = new Producer(10, godown);
		Producer p3 = new Producer(10, godown);
		Producer p4 = new Producer(10, godown);
		Producer p5 = new Producer(10, godown);
		Producer p6 = new Producer(10, godown);
		Producer p7 = new Producer(80, godown);

		c1.start();
		c2.start();
		c3.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
	}
}

/**
 * 生产者
 */
class Producer extends Thread
{
	private int neednum; // 生产产品的数量
	private Godown godown; // 仓库

	Producer(int neednum, Godown godown)
	{
		this.neednum = neednum;
		this.godown = godown;
	}

	public void run()
	{
		// 生产指定数量的产品
		godown.produce(neednum);
	}
}

/**
 * 消费者
 */
class Consumer extends Thread
{
	private int neednum; // 生产产品的数量
	private Godown godown; // 仓库

	Consumer(int neednum, Godown godown)
	{
		this.neednum = neednum;
		this.godown = godown;
	}

	public void run()
	{
		// 消费指定数量的产品
		godown.consume(neednum);
	}
}
