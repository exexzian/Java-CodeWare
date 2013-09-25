/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logics;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EqualPartition_Techgig {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        String flag = partition(array);
        System.out.println(" flag = " + flag);
    }

    public static String partition(int[] input1) {
        boolean validInput = true;
        for (int i = 0; i < input1.length; i++) {
            if (input1[i] <= 0) {
                validInput = false;
                break;
            }
        }
        if (validInput) {
            Set<Integer> s1 = new HashSet<Integer>();
            Set<Integer> s2 = new HashSet<Integer>();
            s1.add(0);
            for (int i = 0; i < input1.length; i++) {
                /* loop over s1 and add to s2 */
                for (Integer x : s1) {
                    s2.add(Math.abs(input1[i] + x));
                    s2.add(Math.abs(input1[i] - x));
                }
                s1.clear();
                s1.addAll(s2);
                s2.clear();
            }
            return s1.contains(0) ? "Yes" : "No";
        } else {
            return "Invalid";
        }
    }

}
