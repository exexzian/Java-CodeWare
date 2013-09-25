/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logics;

import java.awt.Choice;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author bingo http://www.techgig.com/codecontest/problem/Visit-a-Colony-94
 */
public class HouseProblem_Techgig {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 0;
        System.out.println("number of houses = ");
        n = sc.nextInt();
        int[] houseScore = new int[n];

        System.out.println("house scores = ");
        for (int i = 0; i < houseScore.length; i++) {
            houseScore[i] = sc.nextInt();

        }

        System.out.println("house number to check = ");
        int checkHouse = sc.nextInt();

        int status = checkStatus(houseScore, checkHouse);
        System.out.println("status = " + status);

    }

    public static int checkStatus(int houseScore[], int checkHouse) {

        int n = houseScore.length;
        int[] houseStatus = new int[n];
        
        /*
        if (houseScore.length <= 0 || checkHouse > houseScore.length || checkHouse <= 0) {
            System.out.println("size zero invalid");
            return -1;
        }
        if (houseScore[0] == 2 && n == 1) {
            System.out.println("invalid: no 2nd house");
            return -1;
        }
        */
        houseStatus[0] = 1;
        
        if (houseScore[0] >= 3 || houseScore[n - 1] >= 3 || houseScore[0] <= 0) {
            System.out.println("invalid: first or last house 0 or 3");
            return -1;
        }

        for (int i = 0; i < n - 1; i++) {
//            if (houseScore[i] > 3 || (Math.abs(houseScore[i + 1] - houseScore[i]) >= 2)) {
//                System.out.println("invalid: score gap >=2");
//                System.out.println("array = " + Arrays.toString(houseStatus));
//                return -1;
//            }

            if (i != 0) {
                houseStatus[i + 1] = houseScore[i] - houseStatus[i - 1] - houseStatus[i];
//                if (houseStatus[i + 1] != 0 && houseStatus[i + 1] != 1) {
//                    System.out.println("invalid: wrong status");
//                    System.out.println("array = " + Arrays.toString(houseStatus));
//                    return -1;
//                }

            } else {
                houseStatus[i + 1] = houseScore[i] - houseStatus[i];
            }
        }
        if(houseStatus[checkHouse-1]!=0 && houseStatus[checkHouse-1]!=1){
            System.out.println("array = " + Arrays.toString(houseStatus));
            return -1;
        }
        
        /*
        if (n > 1) {
            if (houseStatus[n - 2] + houseStatus[n - 1] != houseScore[n - 1]) {
                System.out.println("extreme");
                System.out.println("array = " + Arrays.toString(houseStatus));
                return -1;
            }
            
        } */

        System.out.println("array = " + Arrays.toString(houseStatus));

        return houseStatus[checkHouse - 1];
    }

}
