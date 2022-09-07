package com.soft.dev.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();

		findParenthesisRecursive("", 0, 0, n, list);

		return list;

	}

	public void findParenthesisRecursive(String str, int open, int close, int n, List<String> list) {

		if (open == n && close == n) {
			list.add(str);
			return;
		}

		if (open < n) {
			findParenthesisRecursive(str + "(", open + 1, close, n, list);
		}

		if (close < open) {
			findParenthesisRecursive(str + ")", open, close + 1, n, list);
		}

	}

	public static void main(String[] args) {
		LC22_GenerateParenthesis obj = new LC22_GenerateParenthesis();

		List<String> list = obj.generateParenthesis(3);
		System.out.println(list);
	}

}
