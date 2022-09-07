package com.soft.dev;

public class RegexPalindrome {

	public String regexPalindrome(String str) {
		int i = 0, j = str.length() - 1;
		while (i <= j) {
			if (str.charAt(i) == '?' && str.charAt(j) != '?') {
				str = str.substring(0, i) + str.charAt(j) + str.substring(i + 1);
			}
			if (str.charAt(j) == '?' && str.charAt(i) != '?') {
				str = str.substring(0, j) + str.charAt(i) + str.substring(j + 1);
			}
			if (str.charAt(i) == '?' || str.charAt(j) == '?') {
				str = str.substring(0, i) + 'a' + str.substring(i + 1);
				str = str.substring(0, j) + 'a' + str.substring(j + 1);
			}
			if (str.charAt(i) != str.charAt(j)) {
				return "NO";
			} else {
				i++;
				j--;
			}
		}
		return str;
	}

	public static void main(String[] args) {

		String str = "bab??a";

		RegexPalindrome obj = new RegexPalindrome();

		String result = obj.regexPalindrome(str);

		System.out.println(result);

	}

}
