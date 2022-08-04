package com.soft.dev.leetcode;

public class LC13_RomanToInteger {
	/*
	 * I 1 V 5 X 10 L 50 C 100 D 500 M 1000
	 * 
	 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
	 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
	 * and M (1000) to make 400 and 900
	 */
	public int romanToInt(String s) {
		int num = 0;

		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'I': {
				num += 1;

			}
				break;
			case 'V': {
				if (i != 0 && s.charAt(i - 1) == 'I') {
					num += 3;
				} else {
					num += 5;
				}
			}
				break;
			case 'X': {
				if (i != 0 && s.charAt(i-1) == 'I') {
					num += 8;
				} else {
					num += 10;
				}

			}
				break;
			case 'L': {
				if (i != 0 && s.charAt(i-1) == 'X') {
					num += 30;
				} else {
					num += 50;
				}
			}
				break;
			case 'C': {
				if (i != 0 && s.charAt(i-1) == 'X') {
					num += 80;
				} else {
					num += 100;
				}
			}
				break;
			case 'D': {
				if (i != 0 && s.charAt(i-1) == 'C') {
					num += 300;
				} else {
					num += 500;
				}
			}
				break;
			case 'M': {
				if (i != 0 && s.charAt(i-1) == 'C') {
					num += 800;
				} else {
					num += 1000;
				}
			}
				break;
			default:
				break;
			}

		}

		return num;
	}

// 1000 + 100 + 800 + 10 + 80 + 1 + 3
	public static void main(String[] args) {
		String s = "MCMXCIV";
		// String s = "MCM";
		LC13_RomanToInteger obj = new LC13_RomanToInteger();
		System.out.println(obj.romanToInt(s));
	}
}
