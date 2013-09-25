/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtraLogical;

//Title of this code
//'main' method must be in a class 'Rextester'.

import java.util.*;
import java.lang.*;

class Rextester
{  
    public static boolean validate(String s) {
        int[] group = new int[4];
        for (char c : s.toCharArray()){
            group[getGroupForChar(c)]++;
        }
        int large = 0;
        for (int g : group){
            if (g >= 2)large++;
        }
        return large>=2;
    }
    private static int getGroupForChar(char c) {
        if (Character.isLowerCase(c))return 0;
        else if (Character.isUpperCase(c))return 1;
        else if (Character.isDigit(c))return 2;
        return 3;
    }
    public static void main(String[] args) {
        String[] tests = new String[]{
            "abAB",
            "aB",
            "ab12",
            "1ab2",
            "asdfasdf1"
        };
        
        for (String s : tests) {
            System.out.println(s+": "+validate(s));
        }
    }
}