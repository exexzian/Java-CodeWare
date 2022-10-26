package com.soft.dev.leetcode;

public class LC_42_TrappingRainWater {
	
	public static void main(String[] args) {
		LC_42_TrappingRainWater obj = new LC_42_TrappingRainWater();
		//int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] height = {4,2,0,3,2,5};
		System.out.println(obj.trap(height));
	}

	public int trap(int[] height) {
		int total = 0;
		if(height.length<=1) {
			return 0;
		}
		int n = height.length;
		int[] left = new int[n];
		int[] right = new int[n];
		
		//left side wall array
		left[0] = height[0];
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i-1], height[i]);
		}
		
		//right side wall array
		right[n-1] = height[n-1];
		for (int i = n-2; i>=0; i--) {
			right[i] = Math.max(right[i+1], height[i]);
		}
		
		//compute total trapped rain
		for (int i = 0; i < n; i++) {
			total += Math.min(left[i], right[i]) - height[i];
		}
		
		return total;
	}

}
