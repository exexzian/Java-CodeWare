package com.soft.dev;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU_LinkedList {
	int capacity;
	HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
	LinkedList<Integer> order = new LinkedList<Integer>();

	LRU_LinkedList(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {

		Integer value = cache.get(key);

		if (value != null) {

			order.remove((Object) key);
			order.addFirst(key);
			return value;
		} else {
			return -1;
		}

	}

	public void put(int key, int value) {

		if (cache.containsKey(key)) {
			order.addFirst(key);
			cache.put(key, value);
		} else {

			if (cache.size() == capacity) {
				order.removeLast();
				order.addFirst(key);
				cache.put(key, value);
			} else {
				order.addFirst(key);
				cache.put(key, value);
			}

		}

	}

}
