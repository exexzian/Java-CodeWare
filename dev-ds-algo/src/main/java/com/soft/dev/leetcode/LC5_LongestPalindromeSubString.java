package com.soft.dev.leetcode;

public class LC5_LongestPalindromeSubString {

	public String longestPalindrome(String s) {
		int len = s.length();
		boolean[][] result = new boolean[len][len];

		int maxLenPalindrome = 0;
		int startPos = 0;

		for (int d = 0; d < len; d++) {

			for (int i = 0, j = d; j < len; i++, j++) {

				if (d == 0) {
					result[i][j] = true;
				} else if (d == 1) {
					result[i][j] = (s.charAt(i) == s.charAt(j)) ? true : false;
				} else {
					if ((s.charAt(i) == s.charAt(j)) && result[i + 1][j - 1]) {
						result[i][j] = true;
					}
				}

				if (result[i][j] && ((d + 1) > maxLenPalindrome)) {
					maxLenPalindrome = d + 1;
					startPos = i;
				}

			}

		}

		return s.substring(startPos, startPos + maxLenPalindrome);
	}

	public static void main(String[] args) {

		LC5_LongestPalindromeSubString obj = new LC5_LongestPalindromeSubString();

		String s = "abccbc";
		System.out.println(obj.longestPalindrome(s));

	}
}
