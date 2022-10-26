package com.soft.dev.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_3SumZero {
	
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		// -4, -1, -1, 0, 1, 2
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {

			// skip duplicates for base first value
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int left = i+1;
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
		System.out.println(obj.threeSumSimple(nums));
	}

	public List<List<Integer>> threeSumSimple(int[] nums) {
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			//a value
			//check for duplicate a
			if(i==0 || nums[i] != nums[i-1]) {
				findPairsUsing2SumApproach(i, i+1,nums.length-1,0-nums[i], nums);
			}
			
		}
		
		return result;
	}

	private void findPairsUsing2SumApproach(int a, int b, int c, int target, int[] nums) {
		
		while(b<c) {
			
			if(nums[b] + nums[c] < target) {
				b++;
			}
			else if(nums[b] + nums[c] > target) {
				c--;
			}else {
				// found the pair
				result.add(Arrays.asList(nums[a],nums[b],nums[c]));
				
				//skip duplicate b
				while(b<c && nums[b] == nums[b+1]) {b++;}
				//skip duplicate c
				while(b<c && nums[c] == nums[c-1]) {c--;}
				
				b++;
				c--;
			}
			
			
		}
		
	}

}
