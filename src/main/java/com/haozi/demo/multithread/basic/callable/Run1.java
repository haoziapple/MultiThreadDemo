package com.haozi.demo.multithread.basic.callable;

public class Run1
{
	public static void main(String[] args)
	{
		Thread.currentThread().setName("Wanghao");
		System.out.println(Thread.currentThread().getName());
	}
}
