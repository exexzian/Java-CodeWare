/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

/**
 *
 * @author hacker
 */
public class RightShiftOpr {
    public static void main(String[] args) {
        byte rsh = 60;
        
        // signed right shift 60>>2 gives 1111
        System.out.println("byte ->60>>2 = " + (byte)(60>>2));
        System.out.println("int -> 60>>2 = "+ (int)(60>>2));
        
        /***** unsigned right shift ********/
        System.out.println("unsigned right shift");
        // doining 60>>>2 gives 0000 1111
        System.out.println("byte ->60>>>2 = " + (byte)(60>>>2));
        System.out.println("int -> 60>>>2 = "+ (int)(60>>>2));
    }
}
