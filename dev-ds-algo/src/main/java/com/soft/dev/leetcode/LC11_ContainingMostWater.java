package com.soft.dev.leetcode;

public class LC11_ContainingMostWater {

	public int maxArea(int[] height) {
		int max = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			if (height[left] < height[right]) {
				max = Math.max(max, height[left] * (right - left));
				left++;
			} else {
				max = Math.max(max, height[right] * (right - left));
				right--;
			}
		}

		return max;

	}

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		LC11_ContainingMostWater obj = new LC11_ContainingMostWater();
		System.out.println(obj.maxArea(height));

	}

}
