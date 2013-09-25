/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author hacker
 */
public class ArrayEquality {
    
      
    public static void main(String[] args) {
        
       
        ArrayEquality obj = new ArrayEquality();
        ArrayEquality obj2 = obj;
        System.out.println("obj.toString = " + (obj2.toString()==obj.toString()) );//== obj2.toString().hashCode()) );
        System.out.println("obj = " + (obj==obj2));
        
        
        String ss="hell";
       
        
        int sLen = ss.length();
        if(sLen>3){
            System.out.println("large");
            JOptionPane.showMessageDialog(null, "big big");
        }
        
        System.out.println("\n" + (int)'e' + " " + (int)'i' + " " + (int)'o' +" " + (int)'u');
        
        char[] aa = { 'a','b','c'};
        char[] bb = { 'a','b','c'};
        
        System.out.println("char array = " + Arrays.equals(aa, bb));
        String a = new String("hello");
        String b = new String("hello");
        
        System.out.println("array = " + Objects.deepEquals(a, b));
        
    }

}
