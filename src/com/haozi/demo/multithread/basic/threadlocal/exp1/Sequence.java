package com.haozi.demo.multithread.basic.threadlocal.exp1;

/**
 * @className:com.haozi.demo.multithread.basic.threadlocal.exp1.Sequence
 * @description:ThreadLocal那点事--例子
 * @version:v1.0.0
 * @date:2016年9月29日 上午10:00:11
 * @author:WangHao
 */
public interface Sequence
{
	/**
	 * @Description:每次调用可获取一个序列号，下子再调用时，序列号自增
	 * @return
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016年9月29日 上午10:01:06
	 */
	int getNumber();
}
