package com.soft.dev.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC1_TwoSumTarget {

	public int[] twoSum(int[] nums, int target) {
		int[] indices = new int[2];
		int temp = -1;
		int temp2 = -1;
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i])) { // check 2
				set.add(target - nums[i]); // 7
			} else {
				temp = nums[i];
				temp2 = target - nums[i];
				indices[0] = i;
				System.out.println("index: " + i);
				System.out.println("temp: " + temp);
				System.out.println("temp2: " + temp2);
				break;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (indices[0] == i) {
				continue;
			}
			if (nums[i] == temp2) {
				indices[1] = i;
				break;
			}
		}

		return indices;
	}

	public int[] twoSumShort(int[] numbers, int target) {

		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {

			Integer diff = (Integer) (target - numbers[i]);
			if (hash.containsKey(diff)) {
				int toReturn[] = { hash.get(diff) + 1, i + 1 };
				return toReturn;
			}

			hash.put(numbers[i], i);

		}

		return null;

	}

	public int[] twoSumMap(int[] nums, int target) {
		Map<Integer, Integer> resultMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (resultMap.containsKey(diff)) {
				return new int[] { i, resultMap.get(diff) };
			} else {
				resultMap.put(nums[i], i);
			}
		}
		return null;

	}
	
	public int[] twoSumTwoPointer(int[]nums, int target) {
		
		int left= 0;
		int right = nums.length-1;
		int sum = 0;
		for (int i = 0; i < nums.length/2; i++) {
			sum = nums[left] + nums[right];
			if(sum == target) {
				return new int[] {left,right};
			}else {
				left++;
				right--;
			}
		}
		
		return null;
	}

	public static void main(String[] args) {

		LC1_TwoSumTarget obj = new LC1_TwoSumTarget();

		//int[] ary = { -1, -2, -3, -4, -5 };
		int[] ary = { 2,7,11,15};
		// int[] ary = { 3,3};
		int target = 9;

		//int[] indices = obj.twoSumMap(ary, target);
		int[] indices = obj.twoSumTwoPointer(ary, target);
		// int[] indices = obj.twoSumShort(ary, target);

		System.out.println("indices: " + Arrays.toString(indices));

	}

}
