package com.soft.dev.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_3SumZero {
	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {

			// skip duplicates for base first value
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int left = i;
			int right = nums.length - 1;

			while (left < right) {

				if (nums[i] + nums[left] + nums[right] == 0) {
					list.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;

					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}

				} else if (nums[i] + nums[left] + nums[right] < 0) {
					left++;
				} else {
					right--;
				}

			}

		}

		return list;

	}

	public static void main(String[] args) {
		LC15_3SumZero obj = new LC15_3SumZero();

		int[] nums = { -1, 0, 1, 2, -1, -4 };
		// -4, -1, -1, 0, 1, 2
		System.out.println(obj.threeSum(nums));
	}

}
