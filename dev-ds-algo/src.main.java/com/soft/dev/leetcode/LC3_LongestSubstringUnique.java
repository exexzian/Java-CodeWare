package com.soft.dev.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC3_LongestSubstringUnique {
	public static void main(String[] args) {

	}

	public int lengthOfLongestSubstring(String s) {

		int left = 0, right = 0, max = 0;
		Set<Character> set = new HashSet<>();

		while (right < s.length()) {

			if (set.add(s.charAt(right))) {
				right++;
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(left));
				left++;
			}

		}

		return max;

	}
}
