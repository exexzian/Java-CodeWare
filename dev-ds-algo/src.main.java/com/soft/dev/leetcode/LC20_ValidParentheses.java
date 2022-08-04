package com.soft.dev.leetcode;

import java.util.Stack;

public class LC20_ValidParentheses {

	// opening brackets : ( { [
	// closing brackets : ) } ]
	public boolean isValid(String s) {
		boolean isValid = true;
		if (s.length() % 2 != 0) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) == '(') || (s.charAt(i) == '{') || (s.charAt(i) == '[')) {
				continue;
			} else if ((s.charAt(i) == ')') && (i - 1 >= 0) && (s.charAt(i - 1) == '(')) {
				s = s.substring(0, i - 1) + s.substring(i + 1);
				i = i - 2;
				System.out.println("inside () s: " + s);
			} else if ((s.charAt(i) == '}') && (i - 1 >= 0) && (s.charAt(i - 1) == '{')) {
				s = s.substring(0, i - 1) + s.substring(i + 1);
				i = i - 2;
				System.out.println("inside {} s: " + s);
			} else if ((s.charAt(i) == ']') && (i - 1 >= 0) && (s.charAt(i - 1) == '[')) {
				s = s.substring(0, i - 1) + s.substring(i + 1);
				i = i - 2;
				System.out.println("inside [] s: " + s);
			} else {
				return false;
			}

			System.out.println("current s: " + s);
		}
		System.out.println("final string: " + s);

		return s.isEmpty();

	}

	public boolean isValidStack(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		// Stack to store left symbols
		Stack<Character> leftSymbols = new Stack<>();
		// Loop for each character of the string
		for (char c : s.toCharArray()) {
			// If left symbol is encountered
			if (c == '(' || c == '{' || c == '[') {
				leftSymbols.push(c);
			}
			// If right symbol is encountered
			else if (c == ')' && !leftSymbols.isEmpty() && leftSymbols.peek() == '(') {
				leftSymbols.pop();
			} else if (c == '}' && !leftSymbols.isEmpty() && leftSymbols.peek() == '{') {
				leftSymbols.pop();
			} else if (c == ']' && !leftSymbols.isEmpty() && leftSymbols.peek() == '[') {
				leftSymbols.pop();
			}
			// If none of the valid symbols is encountered
			else {
				return false;
			}
		}
		return leftSymbols.isEmpty();
	}

	public static void main(String[] args) {
		LC20_ValidParentheses obj = new LC20_ValidParentheses();
		String s = "{[]}";
		System.out.println(obj.isValid(s));

	}

}
