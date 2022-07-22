package com.soft.dev;

import java.io.UnsupportedEncodingException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String encoded = "You donâ€™t have";
		String decoded = new String(encoded.getBytes(), "windows-1252");
		System.out.println(decoded);
		
		System.out.println(encoded.substring(0, 1));
	}
}
