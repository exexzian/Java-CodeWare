package com.soft.dev.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LC8_MyAtoi {

	public int myAtoi(String s) {
		boolean isNegative = false;

		String regex = "\\s*([-+]?)(\\d*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(s);

		if (match.find()) {
			isNegative = "-".equals(match.group(1)) ? true : false;
			String numGroup = match.group(2);
			if (numGroup.isEmpty()) {
				return 0;
			} else {
				try {
					return (int) (isNegative ? -Integer.valueOf(numGroup) : Integer.valueOf(numGroup));
				} catch (Exception e) {
					return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		LC8_MyAtoi obj = new LC8_MyAtoi();
		String s = "-20000000000000000000";

		System.out.println(String.valueOf(Integer.MAX_VALUE).length());
		System.out.println(String.valueOf(Long.MAX_VALUE).length());

		System.out.println("atoi: " + obj.myAtoi(s));

	}
}
