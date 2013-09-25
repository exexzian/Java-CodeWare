/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logics;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author bingo
 */
public class LexicoString {

    public static void main(String[] args) {

        String str;
        Scanner sc = new Scanner(System.in);

        str = sc.nextLine();

        char[] minChar = new char[2];
        int freq = 0;
        minChar[0] = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
//            if(str.charAt(i)==' ' || str.charAt(i) == '.'){
//                continue;
//            }
            if (Character.toString(str.charAt(i)).matches("[\\s,.]")) {
                continue;
            }

            if (str.charAt(i) < minChar[0]) {
                minChar[0] = str.charAt(i);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == minChar[0]) {
                freq++;
            }

        }

        System.out.println("min char = " + minChar[0] + "\t freq = " + freq);
        int[] indexes = new int[freq];

        int frm = 0;
        for (int i = 0; i < freq; i++) {
            indexes[i] = str.indexOf(Character.toString(minChar[0]), frm);
            frm = indexes[i] + 1;

        }

        System.out.println("indexes = " + Arrays.toString(indexes));

        int charIndex = 0, strInd = 0;
        if ((indexes[0] + 1) >= str.length()) {
            strInd = 0;
        } else {
            strInd = indexes[0] + 1;
        }
        minChar[1] = str.charAt(strInd);
     
        int minIndex = indexes[0];
        for (int i = 1, j = 1; i < indexes.length; i++) {
            charIndex = indexes[i] + j;
       
            if (charIndex >= str.length()) {
                charIndex = 0;
            }

            if (str.charAt(charIndex) < minChar[1]) {
                minIndex = indexes[i];
                minChar[1] = str.charAt(charIndex);
            }
            else if (str.charAt(charIndex) == minChar[1]) {
                i--;
                j = j + 1;

                minChar[1] = str.charAt(indexes[0] + j);

            }

        }
        System.out.println("minIndex " + minIndex);

        for (int i = 0, j = minIndex; i < str.length(); i++, j++) {

            System.out.print(str.charAt(j));
            if (j == str.length() - 1) {
                j = -1;
            }

        }
        System.out.println("");
    }

}
