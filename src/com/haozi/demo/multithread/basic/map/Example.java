package com.haozi.demo.multithread.basic.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Example
{
	public static void main(String[] args)
	{
		// Hashtable
		Map<String, String> hashtable = new Hashtable<>();

		// synchronizedMap
		Map<String, String> synchronizedHashMap = Collections.synchronizedMap(new HashMap<String, String>());

		// ConcurrentHashMap
		Map<String, String> concuurentHashMap = new ConcurrentHashMap<>();
	}
}
