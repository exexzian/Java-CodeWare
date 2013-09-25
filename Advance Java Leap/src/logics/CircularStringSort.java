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
public class CircularStringSort {
    public static void main(String[] args) {
        String str=null;
        int len=0;
        
        Scanner sc = new Scanner(System.in);        
        str = sc.nextLine();      
        
        len = str.length();
        
        String[] combiStr = new String[len];        
       
        for (int i = 0,j=0; j < combiStr.length; i++,j++) {
           combiStr[j] = str.substring(i,str.length()) + str.substring(0,i);          
       }
        
        System.out.println("combi = " + Arrays.toString(combiStr));
        Arrays.sort(combiStr);
        System.out.println("lexico output = " + combiStr[0]);
    }
}
