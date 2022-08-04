package com.soft.dev.leetcode;

/**
 * Definition for singly-linked list.
 */

public class LC2_TwoLinkedListSum {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode ptr = null;

		int carry = 0;
		int sum = 0;

		while (l1 != null || l2 != null) {
			int val1 = l1 != null ? l1.val : 0;
			int val2 = l2 != null ? l2.val : 0;
			sum = val1 + val2 + carry;
			carry = sum / 10;
			int lastDigit = sum % 10;

			if (ptr == null) {
				head = ptr = new ListNode(lastDigit);
			} else {
				ptr.next = new ListNode(lastDigit);
				ptr = ptr.next;
			}

			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}

		if (carry != 0) {
			ptr.next = new ListNode(carry);
		}

		return head;
	}

	/*
	 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 =
	 * 807.
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode result = addTwoNumbers(l1, l2);
		System.out.println(result.val + " " + result.next.val + " " + result.next.next.val);

	}
}
