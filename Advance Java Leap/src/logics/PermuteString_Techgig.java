/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author bingo
 */
public class PermuteString_Techgig {

    public static Set<String> streams = new HashSet<>();
    public static int noPattern;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nodes, gaps, ads;
        System.out.println("enter nodes = ");
        nodes = sc.nextInt();
        System.out.println("enter gaps = ");
        gaps = sc.nextInt();
        System.out.println("enter ads = ");
        ads = sc.nextInt();
        noPattern = getStartLogic(nodes, gaps, ads);
        System.out.println(" number of pattern = " + noPattern);
    }

    /**
     * *** start logic ******
     */
    public static int getStartLogic(int nodes, int gaps, int ads) {
        String basePtrn = "";
        if ((ads < 1) || (ads > gaps) || (gaps > 50) || (gaps > nodes) || (nodes > 1000000000)) {
            return -1;
        } else if ((gaps == ads) || ((gaps == nodes - 1) && (ads == nodes - 2)) || ((gaps == nodes - 2) && (ads == nodes - 4))) {
            return 1;
        } else {
            basePtrn = basePattern(nodes, gaps, ads);

            permuteString("", basePtrn, nodes, gaps, ads);

            // System.out.println("sets = " + streams);
            System.out.println("size of set = " + streams.size());

            return streams.size() % 1000000007;
        }
    }

    /**
     * ***** base - pattern logic *********
     */
    public static String basePattern(int nodes, int gaps, int ads) {
        int digits[] = new int[nodes];
        int ones = gaps - ads;
        for (int k = 0; k < gaps; k++) {
            if (k >= ones) {
                digits[k] = 1;
            }
        }

        int j = 0, count = 0;
        for (int i = 1; i <= nodes - gaps; i++) {
            int sum = 0;
            for (j = i, count = 0; count < gaps; j++, count++) {
                sum += digits[j];
            }
            if (sum < ads) {
                digits[j - 1] = 1;
            }
        }

        String baseStr = Arrays.toString(digits);
        baseStr = baseStr.replaceAll(", ", "").replace("[", "").replace("]", "");
        return baseStr;
    }

    /**
     * ********** permute String ***********
     */
    public static void permuteString(String beginningString, String endingString, int nodes, int gaps, int ads) {
        String value = "";
        if (endingString.length() <= 1) {
            value = beginningString + endingString;
          //  System.out.println(value);
            if (checkValidity(value, nodes, gaps, ads)) {
                streams.add(value);
            }
        } else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);
                    
                    permuteString(beginningString + endingString.charAt(i), newString, nodes, gaps, ads);
                } 
                catch (StringIndexOutOfBoundsException exception) {
                    System.out.println("Index Bound Exception");
                }
            }
        }
    }

    public static boolean checkValidity(String value, int nodes, int gaps, int ads) {

        int j = 0, count = 0;
        for (int i = 0; i <= nodes - gaps; i++) {
            int sum = 0;
            for (j = i, count = 0; count < gaps; j++, count++) {
                sum += Integer.parseInt(Character.toString(value.charAt(j)));
            }
            if (sum < ads) {
                return false;
            }
        }
        return true;
    }
}
