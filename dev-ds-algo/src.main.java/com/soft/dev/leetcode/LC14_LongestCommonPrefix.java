package com.soft.dev.leetcode;

public class LC14_LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		StringBuilder prefix = new StringBuilder("");
		
		int minStr = strs[0].length();
		
		for (int i = 0; i < strs.length; i++) {
			if(strs[i].length() < minStr) {
				minStr = strs[i].length();
			}
		}
		
		for (int i = 0; i < minStr; i++) {
			
			char curr = strs[0].charAt(i);
			
			for (int j = 0; j < strs.length; j++) {
				if(strs[j].charAt(i) != curr) {
					return prefix.toString();
				}
			}
			prefix.append(curr);
		}

		return prefix.toString();
	}

	public static void main(String[] args) {
		LC14_LongestCommonPrefix obj = new LC14_LongestCommonPrefix();
		
		String[] strs = {"flower","flo","flowo","flowwing"};
		
		System.out.println("test:" + obj.longestCommonPrefix(strs));
	}
}
