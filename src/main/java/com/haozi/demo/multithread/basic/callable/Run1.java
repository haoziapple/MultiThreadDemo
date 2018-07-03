package com.haozi.demo.multithread.basic.callable;

import java.util.Date;

public class Run1
{
	public static void main(String[] args)
	{
		Thread.currentThread().setName("Wanghao");
        System.out.println(new Date());
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date());
        System.out.println(System.currentTimeMillis());
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getState());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getName());
	}
}
