/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logics;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author bingo
 */
public class CircularStringSort_SpaceComplexity {

    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);

        str = sc.nextLine();

        char minChar;
        int freq = 0;
        minChar = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i)==' ' || str.charAt(i) == '.'){
                continue;
            }          
            if (str.charAt(i) < minChar) {
                minChar = str.charAt(i);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == minChar) {
                freq++;
            }
        }

        System.out.println("min char = " + minChar + "\t freq = " + freq);
        int[] indexes = new int[freq];

        int frm = 0;
        for (int i = 0; i < freq; i++) {
            indexes[i] = str.indexOf(Character.toString(minChar), frm);
            frm = indexes[i] + 1;
        }

        String[] combiStr = new String[freq];

        for (int i = 0, j = 0; j < indexes.length; i++, j++) {
            String temp = str.substring(indexes[i], str.length());
            combiStr[j] = temp + str.substring(0, indexes[i]);

        }

        System.out.println("combi = " + Arrays.toString(combiStr));
        Arrays.sort(combiStr);
        System.out.println("lexico output = " + combiStr[0]);
    }
}
