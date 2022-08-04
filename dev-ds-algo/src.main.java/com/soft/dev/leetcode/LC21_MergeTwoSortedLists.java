package com.soft.dev.leetcode;

public class LC21_MergeTwoSortedLists {

	/*
	 * Input: l1 = [1,2,4], l2 = [1,3,4] Output: [1,1,2,3,4,4] 4,5,7 2,3 - l2 -> 3
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;

		// Check if any of the lists are null
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		ListNode curr = head;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}

		// add remaining elements for l1
		while (l1 != null) {
			curr.next = l1;
			l1 = l1.next;
			curr = curr.next;
		}

		// add remaining elements for l2
		while (l2 != null) {
			curr.next = l2;
			l2 = l2.next;
			curr = curr.next;
		}

		return head;

	}

	public void displayLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		LC21_MergeTwoSortedLists obj = new LC21_MergeTwoSortedLists();

		ListNode f1 = new ListNode(1);
		ListNode f2 = new ListNode(2);
		ListNode f3 = new ListNode(4);

		ListNode s1 = new ListNode(1);
		ListNode s2 = new ListNode(3);
		ListNode s3 = new ListNode(5);

		f1.next = f2;
		f2.next = f3;

		s1.next = s2;
		s2.next = s3;

		ListNode result = obj.mergeTwoLists(f1, s1);

		obj.displayLinkedList(result);

	}

}
