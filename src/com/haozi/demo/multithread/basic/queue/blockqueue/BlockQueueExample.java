package com.haozi.demo.multithread.basic.queue.blockqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @className:com.haozi.demo.multithread.basic.queue.blockqueue.BlockQueueExample
 * @description:一个阻塞队列的实现
 * @version:v1.0.0
 * @date:2016年9月30日 上午9:30:09
 * @author:WangHao
 */
public class BlockQueueExample
{
	private List list = new ArrayList();

	public synchronized Object pop() throws InterruptedException
	{
		while (list.size() == 0)
		{
			this.wait();
		}

		if (list.size() > 0)
		{
			return list.remove(0);
		} else
		{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public synchronized void put(Object obj)
	{
		list.add(obj);
		this.notify();
	}
}
