package com.soft.dev.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC78_Subsets {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };

		LC78_Subsets obj = new LC78_Subsets();

		obj.subsetsIterative(arr);
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		obj.subsetsBackTracking(0, arr, new ArrayList<Integer>(), res);
		System.out.println("subset using backtracking");
		System.out.println(res);

	}

	// complexity
	// T = n * 2^n
	// S = n * 2^n
	public List<List<Integer>> subsetsIterative(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		res.add(Collections.emptyList());
		List<Integer> temp = null;
		for (Integer num : nums) {
			int n = res.size();
			for (int j = 0; j < n; j++) {
				temp = new ArrayList<Integer>(res.get(j));
				temp.add(num);
				res.add(temp);
			}
		}
		System.out.println(res);
		return res;
	}
	
	public void subsetsBackTracking(int index, int[] nums, List<Integer> curr, List<List<Integer>> res) {
		
		res.add(new ArrayList<Integer>(curr));
		
		for (int i = index; i < nums.length; i++) {
			
			curr.add(nums[i]);
			subsetsBackTracking(i+1, nums, curr, res);
			curr.remove(curr.size()-1);
			
		}
		
	}

}
