package com.soft.dev.leetcode;

import java.util.Optional;

public class LC23_MergeKSortedLists {
	
	
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode list = new ListNode();
		
		if(lists == null || lists.length == 0) {
			return null;
		}
		
		list = mergeKLists(lists,0,lists.length -1);
		
		return list;
	}

	private ListNode mergeKLists(ListNode[] lists, int start, int end) {
		
		if(start == end) {
			return lists[start];
		}
		
		int mid = start + (end-start)/2;
		
		ListNode left = mergeKLists(lists,start,mid);
		ListNode right = mergeKLists(lists,mid+1,end);
		
		return mergedTwoSortedList(left,right);
	}

	private ListNode mergedTwoSortedList(ListNode left, ListNode right) {
		ListNode head = new ListNode(-1);
		
		if(left == null) {
			return right;
		}
		if(right == null) {
			return left;
		}
		
		ListNode temp = head;

		while(left != null & right != null) {
			if(left.val < right.val) {
				temp.next = left;
				left = left.next;
			}else {
				temp.next = right;
				right = right.next;
			}
			
			temp = temp.next;
		}
		
		while(left != null) {
			temp.next = left;
			left = left.next;
			temp = temp.next;
		}
		while(right != null) {
			temp.next = right;
			right = right.next;
			temp = temp.next;
		}
		
		return head.next;
	}

	public void display(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.val + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		LC23_MergeKSortedLists obj = new LC23_MergeKSortedLists();
		String d = "";
		String name = Optional.of(d)
				  .orElse("test");
		System.out.println(name);
		
	}

}
