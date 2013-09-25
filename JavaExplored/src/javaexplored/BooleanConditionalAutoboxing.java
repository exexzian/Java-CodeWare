/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexplored;

/**
 * http://stackoverflow.com/questions/3882095/booleans-conditional-operators-and-autoboxing
 * @author hacker
 */
public class BooleanConditionalAutoboxing {
    
    public static void main(String[] args) {
        Boolean b = null;
        try {
            b = true ? returnsNull() : false; // NPE on this line.
            
        } catch ( NullPointerException e) {
            System.out.println("Null pointer Exception");
            b= null;
            e.printStackTrace();
        }
        
        System.out.println("b - "+b);
        
        Boolean b2 = true ? null : false;
        System.out.println("b2 - "+b2); // null
    }
    
    public static Boolean returnsNull() {
        return null;
    }

}
