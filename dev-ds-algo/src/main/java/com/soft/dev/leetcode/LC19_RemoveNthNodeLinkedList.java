package com.soft.dev.leetcode;

public class LC19_RemoveNthNodeLinkedList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode temp = head;
		int size = linkedListSize(temp);
		if (size == 1) {
			return null;
		}
		if(size == n) {
			return head.next;
		}
		int i = size-1;
		while (temp != null) {
			if (i == n) {
				if (temp.next != null && temp.next.next != null) {
					System.out.println("val: "+temp.val);
					temp.next = temp.next.next;
				} else {
					temp.next = null;
				}
			}
			temp = temp.next;
			i--;
		}

		return head;
	}

	public int linkedListSize(ListNode head) {
		ListNode curr = head;
		int size = 0;
		while (curr != null) {
			curr = curr.next;
			size++;
		}
		return size;
	}

	public void displayLinkedList(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
	}

	public static void main(String[] args) {

		LC19_RemoveNthNodeLinkedList obj = new LC19_RemoveNthNodeLinkedList();

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		System.out.println("Before------");
		obj.displayLinkedList(l1);

		/*
		 * l3.next = l4; l4.next = l5;
		 */
		
		System.out.println();

		ListNode newNode = obj.removeNthFromEnd(l1, 2);
		System.out.println("After------");
		obj.displayLinkedList(newNode);
	}

}
