/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

import java.util.Scanner;

/**
 *
 * @author hacker
 */
public class NullCheck {
    
    public boolean nullCheck(String str){
        
         if (str.equals("a")) {
            System.out.println();
            return true;
            
        }
        else
            return false;
    }
    
    public static void main(String[] args) {
        
        String str=null;
        
        NullCheck obj = new NullCheck();
        System.out.println("nullcheck returned-");
       obj.nullCheck(str);
        
        StringBuilder strBuild = new StringBuilder();
        System.out.println("strBuild " + strBuild);
        
    }
}
