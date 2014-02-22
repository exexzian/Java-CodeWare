/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author bingo
 */
public class SmallestUnique {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(
                new FileReader("...\\resources\\SmaalestUniqueTestCases.txt")
                )) {

            String line;

            while ((line = br.readLine()) != null) {
               // System.out.println(line);
                findUnique(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findUnique(String line) {

        int numLength = line.length()/2+1;
        int[] nums = new int[numLength];
        int[] range = new int[10]; 

        for (int i = 0, j = 0; i < line.length(); j++, i = i + 2) {
            nums[j] = Integer.parseInt(String.valueOf(line.charAt(i)));
            range[nums[j]]++;
        }

        int index = 0;
        for (int i = 1; i < range.length; i++) {
            if (range[i] == 1) {
               index =  line.indexOf(String.valueOf(i)) / 2 + 1;
                break;
            } else {
                index = 0;
            }
            
        }
     //   System.out.println("index of min = " + index );
        System.out.println(index );
    }

}
