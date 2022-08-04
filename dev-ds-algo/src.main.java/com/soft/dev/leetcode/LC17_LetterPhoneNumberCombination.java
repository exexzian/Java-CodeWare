package com.soft.dev.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC17_LetterPhoneNumberCombination {

	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		if (digits.isEmpty()) {
			return list;
		}
		String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		StringBuilder str = new StringBuilder();
		findCombinationsBacktrack(digits, mapping, list, 0, str);

		return list;
	}

	private void findCombinationsBacktrack(String digits, String[] mapping, List<String> list, int i,
			StringBuilder str) {

		if (i == digits.length()) {
			// System.out.println(list);
			list.add(str.toString());
			return;
		}
		int digit = Character.getNumericValue(digits.charAt(i));
		String curr = mapping[digit];

		for (int j = 0; j < curr.length(); j++) {
			str.append(curr.charAt(j));
			findCombinationsBacktrack(digits, mapping, list, i + 1, str);
			str.deleteCharAt(str.length() - 1);
		}

	}

	public List<String> letterCombinationsIterative(String digits) {
		List<String> list = new ArrayList<String>();
		if (digits.isEmpty()) {
			return list;
		}
		String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		return list;
	}

	public static void main(String[] args) {

		LC17_LetterPhoneNumberCombination obj = new LC17_LetterPhoneNumberCombination();

		List<String> list = obj.letterCombinations("23");
		System.out.println(list);

	}

}
