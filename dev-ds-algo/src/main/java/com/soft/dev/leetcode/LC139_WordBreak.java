package com.soft.dev.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC139_WordBreak {

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>(Arrays.asList("leet", "code"));

		System.out.println(wordBreak(s, wordDict));

	}

	public static boolean wordBreak(String s, List<String> wordDict) {

		Map<Integer, Boolean> posToValue = new HashMap<Integer, Boolean>();
		return isValid(s, new HashSet<String>(wordDict), 0, posToValue);

	}

	public static boolean isValid(String s, Set<String> wordDict, int start, Map<Integer, Boolean> map) {

		if (map.containsKey(start) && !map.get(start)) {
			System.out.print("true");
			return false;
		}
		if (s.length() == start) {
			return true;
		}

		for (int i = start; i < s.length(); i++) {
			String word = s.substring(start, i + 1);
			if (wordDict.contains(word) && isValid(s, wordDict, i + 1, map)) {
				return true;
			} else {
				map.put(start, false);
			}

		}

		return false;

	}
}