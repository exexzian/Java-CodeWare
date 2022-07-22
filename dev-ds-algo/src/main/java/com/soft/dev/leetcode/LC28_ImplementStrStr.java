package com.soft.dev.leetcode;

public class LC28_ImplementStrStr {

	public static void main(String[] args) {
		LC28_ImplementStrStr obj = new LC28_ImplementStrStr();
		String haystack = "hello";
		String needle = "ll";
		System.out.println(obj.strStr(haystack, needle));

	}

	public int strStr(String haystack, String needle) {

		if (needle.length() == 0) {
			return 0;
		}

		int limit = haystack.length() - needle.length() + 1;
		// System.out.println(limit);
		for (int i = 0; i < limit; i++) {
			int j = 0;
			for (; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == needle.length()) {
				return i;
			}
		}
		return -1;
	}
}
