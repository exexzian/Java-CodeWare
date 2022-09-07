package com.soft.dev.leetcode;

import java.util.HashMap;

public class LC146_LRUCache {
	
	HashMap<Integer, Node> cache;
	Node head;
	Node tail;
	int capacity;
	
	public LC146_LRUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<Integer, Node>(capacity);
	}
    
    public int get(int key) {
    	
    	if(cache.containsKey(key)) {
    		Node node = cache.get(key);
    		
    		moveToFront(node);
    		
    		return node.value;
    		
    	}else {
    		return -1;
    	}
    	
    }
    
    private void moveToFront(Node node) {
    	
    	removeNode(node);
    	addFirst(node);
    	
    	
	}

	private void addFirst(Node node) {
		
		node.next = head;
		node.prev = null;
		
		if(head != null) {
			head.prev = node;
		}
		
		head = node;
		
		if(tail == null) {
			tail = node;
		}
		
	}

	private void removeNode(Node node) {
		
		Node prevNode = node.prev;
		Node nextNode = node.next;
		
		if(prevNode != null) {
			prevNode.next = nextNode;
		}else {
			head = nextNode;
		}
		
		if(nextNode != null) {
			nextNode.prev = prevNode;
		}else {
			tail = prevNode;
		}
	
		
	}

	public void put(int key, int value) {
        
		if(cache.containsKey(key)) {
			Node node = cache.get(key);
			node.value = value;
			addFirst(node);
		}else {
			Node node = new Node(key, value);
			if(cache.size() == capacity) {
				cache.remove(tail.key);
				removeNode(tail);
			}
			cache.put(key, node);
			addFirst(node);

		}
		
		
    }

	public static void main(String[] args) {
		
		int capacity = 2;
		LC146_LRUCache lRUCache = new LC146_LRUCache(capacity);
		
		lRUCache.put(1, 1);
		System.out.println(lRUCache.cache);

		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.cache);
		
		System.out.println(lRUCache.get(1));

		lRUCache.put(3, 3);
		System.out.println(lRUCache.cache);

		System.out.println(lRUCache.get(2));    // return 1

		lRUCache.put(4, 4);
		System.out.println(lRUCache.cache);

		System.out.println(lRUCache.get(1));   
		System.out.println(lRUCache.get(3));   
		System.out.println(lRUCache.get(4));   
		
		System.out.println(lRUCache.cache);
		
		System.out.println(lRUCache.head);
		
	}
	
	class Node{
		
		int key,value;
		Node next;
		Node prev;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
		
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + "]";
		}
		
	}

}
