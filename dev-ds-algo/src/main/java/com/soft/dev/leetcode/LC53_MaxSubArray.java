package com.soft.dev.leetcode;

public class LC53_MaxSubArray {

	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if(sum > max) {
				max = sum;
			}
			if(sum<0) {
				sum = 0;
			}
		}
		
		System.out.println("max = "+ max);
		
		max = nums[0];
		sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			
			sum = Math.max(nums[i], sum+nums[i]);
			max = Math.max(sum, max);
			
		}
		
		System.out.println("max2 = "+ max);


		return max;
	}

	public static void main(String[] args) {
		
		LC53_MaxSubArray obj = new LC53_MaxSubArray();
		
		//int[] nums = {1};
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(obj.maxSubArray(nums));

	}
}
