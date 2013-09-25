/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logics;

import java.util.Scanner;

/**
 *
 * @author bingo
 */
public class LargestSubset {
    
    public static void main(String[] args) {
        System.out.println("" + Math.ceil(-3.1));
        String s1;
        String s2;
        Scanner sc = new Scanner(System.in);
        int count=0;
        s1 = sc.next();
        s2 = sc.next();
        
        
        for (int i = 0; i < s1.length(); i++) {
              if(Character.isLowerCase(s1.charAt(i))||Character.isLowerCase(s2.charAt(i))){
                System.out.println(0);
                return;
        }
            for (int j = 0; j < s2.length(); j++) {                
         
           if(s1.charAt(i)==s2.charAt(j)){
               count++;
           }
            
        }
        }
        
        System.out.println(count);
    }
    
    
}
