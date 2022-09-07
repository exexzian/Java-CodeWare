package com.soft.dev.leetcode;

public class AmazonEncodedStringMatrix {

	public static void main(String[] args) {
		String result = convert("mnes__ya_____mi",3);
		System.out.println(result);
	}
	public static String convert(String s, int numRows) {
        String result = "";
        if (s.length() <= numRows || numRows == 1)
            return s;
        int count =0;
        for (int i=0; i < s.length()/numRows; i++){
            int next = i;
            while (next < s.length()){
            	count++;
            	if(s.charAt(next)=='_') {
            		if(result.charAt(result.length()-1)!=' ')
            		result = result + " ";	
            	}
            	else {
            		   result = result + Character.toString(s.charAt(next));	
            	}
                int step = (s.length()/numRows) + 1;
                next += step;
            }
        }   
        result=result.trim();
        System.out.println("count: " +count);
        return result;
    }
}
