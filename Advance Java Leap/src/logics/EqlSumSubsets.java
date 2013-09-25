/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logics;

import java.util.*;

/**
 *
 * @author bingo
 * http://www.techgig.com/codecontest/problem/Partition-Problem-96
 */
public class EqlSumSubsets {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        String flag = equalSubsets(array, n);
        System.out.println(" flag = " + flag);
    }

    public static String equalSubsets(int array[], int n) {
        String flag = "No";
        float sum = 0, half = 0;
        int even = 0, odd = 0;

        for (int i = 0; i < n; i++) {
            if (array[i] <= 0) {
                return "Invalid";
            }
            if (array[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            sum += array[i];
        }
        System.out.println("sum = " + sum + " Even = " + even + " odd = " + odd);
        if ((sum % 2 != 0) || (even == n && odd == 0 && sum % 4 != 0)) {
            return "No";
        } else {

            half = (int) sum / 2;
            System.out.println("half = " + half);
            for (int j = 0; j < array.length; j++) {
                sum = 0;
                for (int i = j; i < array.length; i++) {

                    sum += array[i];
                    if (sum > half) {
                        sum = sum - array[i];
                        continue;
                    }
                    if (sum == half) {
                        return "Yes";
                    }

                }
            }
        }

        return flag;
    }

}
