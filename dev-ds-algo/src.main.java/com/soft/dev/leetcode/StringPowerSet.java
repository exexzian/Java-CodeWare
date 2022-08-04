package com.soft.dev.leetcode;

public class StringPowerSet {
	
	public static int counter = 0;

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		printPowerSet("abc", -1, 3, "");
		long end = System.currentTimeMillis();
		long time1 = end - start;

		System.out.println("--------------------------------------");
		
		start = System.currentTimeMillis();
		recursivePowerSet("abc", 0, "");
		end = System.currentTimeMillis();
		long time2 = end - start;
		
		System.out.println("--------------------------------------");
		
		start = System.currentTimeMillis();
		reverseRecursivePowerSet("abc", "");
		end = System.currentTimeMillis();
		long time3 = end - start;

		
		System.out.println("Method printPowerSet execution lasted:" + time1 + " ms");
		System.out.println("Method recursivePowerSet execution lasted:" + time2 + " ms");
		System.out.println("Method reverseRecursivePowerSet execution lasted:" + time3 + " ms");

		
		
	}
	
	public static void printPowerSet(String s, int index, int n, String current) {
		
		/*
		 * if (index == n) { System.out.println("exit from stack: index:" + index +
		 * " | " + "curr: " + current); return; }
		 */
		
		System.out.println("1:" + current);

		for (int i = index + 1; i < n; i++) {
			current += s.charAt(i);
			printPowerSet(s, i, n, current);
			current = current.substring(0, current.length() - 1);  // backtracking
		}
	}

	public static void recursivePowerSet(String s, int i, String curr) {
		if (i == s.length()) {
			System.out.println("2: " + curr);
			return;
		}

		recursivePowerSet(s, i + 1, curr + s.charAt(i));
		recursivePowerSet(s, i + 1, curr);
	}
	
	
	public static void reverseRecursivePowerSet(String input, String output) {
		if(input.length() == 0) {
			System.out.println("3: " + output);
			return;
		}
		
		reverseRecursivePowerSet(input.substring(1), output);
		reverseRecursivePowerSet(input.substring(1), output + input.substring(0, 1));
		
	}

}
