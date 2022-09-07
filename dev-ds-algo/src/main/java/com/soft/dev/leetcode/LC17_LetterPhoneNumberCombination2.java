package com.soft.dev.leetcode;

/**
 * smallest solution
 * https://github.com/reachanihere/Data-Structures-and-Algorithms/blob/master/Recursion%20-2/Print%20Keypad%20Combination%20Code.cpp
 * 
 * @author santosh
 *
 */
public class LC17_LetterPhoneNumberCombination2 {

	static String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };


	public static void main(String[] args) {

		LC17_LetterPhoneNumberCombination2 obj = new LC17_LetterPhoneNumberCombination2();
		obj.printKeypadComboSimple("123");
	}
	
	public void printKeypadComboSimple(String num) {
		recursiveKeypadCombination(num, "");
	}

	private void recursiveKeypadCombination(String num, String output) {
		if(num.length() == 0) {
			System.out.println(output);
			return;
		}
		int n = Character.getNumericValue(num.charAt(0));

		String letters = mapping[n];
		// dry run
		// 234
			// 2
			// abc
		
		// handle case if keypad num is 0 or 1
		// -- then perform recursion with only existing output and remove the current element from num
		if(letters.length()==0&&num.length()!=0) {
			recursiveKeypadCombination(num.substring(1), output);
		}
		
		for (int i = 0; i < letters.length(); i++) {
			recursiveKeypadCombination(num.substring(1), output + letters.charAt(i));
			// 34 , 1, a
		}
		//dry run
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
