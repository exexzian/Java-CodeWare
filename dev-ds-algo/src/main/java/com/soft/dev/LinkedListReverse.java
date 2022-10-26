package com.soft.dev;

public class LinkedListReverse {

	static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static class LinkedList {

		public Node head;

		public LinkedList() {
			this.head = null;
		}

		public void insertNode(int data) {

			Node node = new Node(data);

			if (this.head != null) {
				node.next = head;
			}

			this.head = node;

		}
	}

	public static void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
	}

	// 1 -> 2 -> 3 -> 4
	public static Node iterativeReverse(Node head) {
		Node prev = null;
		Node temp = null;
		Node curr = head;
		
		while(curr!=null) {
			
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			
		}
		
		head = prev;
		
		return head;
		
	}
	
	// 1 -> 2 -> 3 -> 4
	public static Node recusriveReverse(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		Node newHead = recusriveReverse(head.next);
		
		Node headNext = head.next;
		headNext.next = head;
		head.next = null;
		
		return newHead;
	}

	public static void main(String[] args) {

		LinkedList llist = new LinkedList();

		llist.insertNode(20);
		llist.insertNode(4);
		llist.insertNode(15);
		llist.insertNode(85);

		System.out.println("Given linked list:");
		printLinkedList(llist.head);

		System.out.println();
		System.out.println("Reversed Linked list Iteratively:");
		Node llist1 = iterativeReverse(llist.head);
		printLinkedList(llist1);
		
		System.out.println();
		System.out.println("Reversed Linked list recursively:");
		Node llist2 = recusriveReverse(llist1);
		printLinkedList(llist2);

	}

}
