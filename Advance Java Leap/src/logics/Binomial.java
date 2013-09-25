/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logics;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://introcs.cs.princeton.edu/java/96optimization/
 *
 * @author bingo
 */
public class Binomial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter n = ");
        int N = sc.nextInt();
        System.out.println("enter k = ");
        int K = sc.nextInt();

        long[][] binomial = new long[N + 1][K + 1];

        // base cases
        for (int k = 1; k <= K; k++) {
            binomial[0][k] = 0;
        }
        for (int n = 0; n <= N; n++) {
            binomial[n][0] = 1;
        }

        //System.out.println("array = " + Arrays.deepToString(binomial));
        
        StringBuilder sb = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");
        for (long[] row : binomial) {
            sb.append(Arrays.toString(row)).append(lineSeparator);
        }
        String text = sb.toString();
//-----------------------------
        System.out.println(text);
        
        // bottom-up dynamic programming
        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= K; k++) {
                binomial[n][k] = binomial[n - 1][k - 1] + binomial[n - 1][k];
            }
        }

        System.out.println("binomial coefficient =  " + binomial[N][K]);

    }
}
