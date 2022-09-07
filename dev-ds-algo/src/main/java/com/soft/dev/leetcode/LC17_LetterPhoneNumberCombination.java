package com.soft.dev.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * smallest solution
 * https://github.com/reachanihere/Data-Structures-and-Algorithms/blob/master/Recursion%20-2/Print%20Keypad%20Combination%20Code.cpp
 * 
 * @author santosh
 *
 */
public class LC17_LetterPhoneNumberCombination {

	static String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

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

		List<String> list = obj.letterCombinations("234");
		System.out.println(list);
		
		obj.printKeypadComboSimple("234");
	}
	
	public void printKeypadComboSimple(String num) {
		recursiveKeypadCombination(num, "");
	}

	private void recursiveKeypadCombination(String num, String output) {
		
		if(num.length() == 0) {
			System.out.println(output);
			return;
		}
		System.out.println("------------- iteration for: " + String.valueOf(num.charAt(0)));
		int n = Character.getNumericValue(num.charAt(0));
		String letters = mapping[n];
		System.out.println("letters at "+n+" -> "+letters);
		// 234
			// 2
			// abc
		System.out.println("num: " + num);
		
		for (int i = 0; i < letters.length(); i++) {
			
			// prepare for next recursion
			/* DONT change reference
			if(num.length() <=1) {
				num = "";
			}else {
				num = num.substring(1);
			}
			output = output + letters.charAt(i);
			*/
			recursiveKeypadCombination(num.substring(1), output + letters.charAt(i));
			// 34 , 1, a
		}
		
		// index = 1
		// 34, 1, a
			// n = 3
				// def
		//loop
			//num = 4
			// output = a+d
		//fun = 4,1,ad
		
		// next....
		// 4,1,ad
		// n = 4
			// ghi
		//loop 
			// num = ""
			//output = adg
		//fun = "", 1, adg
		
		
		
		
		
	}
	

}
