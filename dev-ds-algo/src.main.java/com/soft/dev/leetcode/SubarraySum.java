package com.soft.dev.leetcode;

import java.util.HashMap;
import java.util.Map;

class SubarraySum {
	// Function to print subarray having a given sum using hashing
	public static void findSubarray(int[] A, int target) {
		// create an empty map
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		// insert `(0, -1)` pair into the set to handle the case when a
		// subarray with the given sum starts from index 0
		map.put(0, -1);

		// keep track of the sum of elements so far
		int sum_so_far = 0;

		// traverse the given array
		for (int i = 0; i < A.length; i++) {
			// update `sum_so_far`
			sum_so_far += A[i];

			// if `sum_so_far - target` is seen before, we have found
			// the subarray with sum equal to `target`
			if (map.containsKey(sum_so_far - target)) {
				System.out.print("Subarray found [" + (map.get(sum_so_far - target) + 1) + "–" + i + "]");
				return;
			}

			// insert (current sum, current index) pair into the map
			map.put(sum_so_far, i);
		}
		System.out.println("No subarray found");
	}

	public static void main(String[] args) {
		// an integer array
		int[] A = { 1, 2, 3, 7, 5 };
		int target = 1;

		/**
		 * 1 , 0 3, 1 6, 2 13, 3 18, 4
		 */
		 findSubarray(A, target);
		//findSubArraySumOptimized(A, target);
	}

	public static void findSubArraySumOptimized(int[] ary, int target) {
		int l = 0;
		int r = -1;
		int sum = 0;
		for (int i = 0; i < ary.length; i++) {

			sum += ary[i];
			r++;
			System.out.println("sum: " + sum + " | r: " +r);
			
			if(sum == target) {
				System.out.println("subarray indices are : left: " + l + " | right: " + r);
				return;
			}
			if (sum > target) {
				System.out.println("inside if: sum: " + sum);
				for (int j = 0; j < r; j++) {
					System.out.println("j: " + j);
					sum = sum - ary[j];
					l++;
					if (sum == target) {
						System.out.println("subarray indices are : left: " + l + " | right: " + r);

						return;
					}

				}
				System.out.println("test");

			}

		}

	}

}