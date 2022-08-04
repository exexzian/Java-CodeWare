package com.soft.dev.leetcode;

public class LC7_ReverseInteger {

	public int reverse(int x) {

		long num = 0;
		boolean isNegative = false;

		if (x < 0) {
			x = -x;
			isNegative = true;
		}
		// 123
		while (x > 0) {

			num = num * 10 + x % 10;
			x = x / 10;
		}

		if (num > Integer.MAX_VALUE) {
			return 0;
		}

		return (int) ((isNegative) ? -num : num);

	}

	public static void main(String[] args) {
		LC7_ReverseInteger obj = new LC7_ReverseInteger();

	}

}
