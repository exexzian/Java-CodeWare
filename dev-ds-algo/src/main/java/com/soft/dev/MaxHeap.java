package com.soft.dev;

import java.util.PriorityQueue;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

public class MaxHeap {

	int[] heap;
	int size;
	int maxSize;

	public MaxHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		this.heap = new int[maxSize];
	}

	// parent pos
	public int getParent(int pos) {
		return (pos - 1) / 2;
	}

	public int getLeft(int pos) {
		return pos * 2 + 1;
	}

	public int getRight(int pos) {
		return pos * 2 + 2;
	}

	public boolean isLeaf(int pos) {
		if (pos * 2 + 1 > size) {
			return true;
		} else {
			return false;
		}
	}

	public void swap(int fpos, int spos) {
		int temp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = temp;
	}

	public void insert(int data) {
		heap[size] = data;
		int currPos = size;
		while (heap[currPos] > heap[getParent(currPos)]) {
			swap(currPos, getParent(currPos));
			currPos = getParent(currPos);
		}

		size++;

	}

	public int extractMax() {
		int root = heap[0];
		heap[0] = heap[size - 1];

		maxHeapify(0);
		size--;
		return root;
	}

	public void maxHeapify(int pos) {
		// if only node
		if (isLeaf(pos)) {
			return;
		}

		if (heap[pos] < heap[getLeft(pos)] || heap[pos] < heap[getRight(pos)]) {

			if (heap[getLeft(pos)] > heap[getRight(pos)]) {
				swap(pos, getLeft(pos));

				maxHeapify(getLeft(pos));
			} else {
				swap(pos, getRight(pos));
				maxHeapify(getRight(pos));
			}
		}

	}

	// To display heap
	public void print() {

		for (int i = 0; i < size / 2; i++) {

			System.out.print("Parent Node : " + heap[i]);

			if (getLeft(i) < size) // if the child is out of the bound of the array
				System.out.print(" Left Child Node: " + heap[getLeft(i)]);

			if (getRight(i) < size) // if the right child index must not be out of the index of the array
				System.out.print(" Right Child Node: " + heap[getRight(i)]);

			System.out.println(); // for new line

		}

	}
	
	
	public int minElementMaxHeap(int[] heap, int size) {
		
		int element = heap[size/2];
		
		for(int i=1+size/2;i<size;i++) {
			
			element = Math.min(element, heap[i]);
			
		}
		
		return element;
	}

	public static void main(String[] args) {

		System.out.println("max heap");

		MaxHeap maxHeap = new MaxHeap(15);

		// Inserting nodes
		// Custom inputs
		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(17);
		maxHeap.insert(10);
		maxHeap.insert(84);
		maxHeap.insert(19);
		maxHeap.insert(6);
		maxHeap.insert(22);
		maxHeap.insert(9);

		// Calling maxHeap() as defined above
		maxHeap.print();

		// Print and display the maximum value in heap
		System.out.println("The max val is " + maxHeap.extractMax());

		System.out.println("Max heap after root extract");
		// Calling maxHeap() as defined above
		maxHeap.print();
		
		System.out.println("-----------------");
		System.out.println("Min Element in max heap:"+ maxHeap.minElementMaxHeap(maxHeap.heap,maxHeap.size));

		System.out.println("-----------------");

		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		  
        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);
        pQueue.add(89);
        pQueue.add(109);
        
        System.out.println("pQueue:");
        System.out.println(pQueue);
        System.out.println(pQueue.peek());
        System.out.println(pQueue.poll());
        System.out.println(pQueue);
        
	}

}
