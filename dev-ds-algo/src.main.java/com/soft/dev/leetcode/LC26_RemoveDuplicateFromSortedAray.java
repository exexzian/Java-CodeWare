package com.soft.dev.leetcode;

public class LC26_RemoveDuplicateFromSortedAray {

	public static void main(String[] args) {
		LC26_RemoveDuplicateFromSortedAray obj = new LC26_RemoveDuplicateFromSortedAray();
	//	int[] nums = {1,1,2,2,2,3,3};
	//	int[] nums = {1,1,2};
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(obj.removeDuplicates(nums));

	}

	public int removeDuplicates(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}
