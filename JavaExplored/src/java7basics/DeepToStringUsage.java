/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

import java.util.Arrays;

public class DeepToStringUsage {

    public static void main(String[] args) {
        
        // deepToString is used to print array of objects
        int[] array = {1,5,8};   // array of primitive data types can't be printed using deepToString()  
        Integer[] ary1D = {7,9,8};
        Integer[] ary1D2 = {7,9,8};
        int[][] ary2 = {{1,2,3},{6,5,4}};
        int[][][] ary3 = {{{1,2},{3,4}},{{5,6},{7,8}}};
        
        System.out.println("single dimensional using simple toString - "+ Arrays.toString(array));
        // System.out.println("using deepequals single dimensional- "+ Arrays.deepToString(array));
        System.out.println("single dimensional- "+ Arrays.deepToString(ary1D));
        System.out.println("2D array- "+ Arrays.deepToString(ary2));
        System.out.println("3D array- "+ Arrays.deepToString(ary3));
        
        System.out.println("comparing two array values = " + Arrays.equals(ary1D, ary1D2));
        System.out.println("using deep equals = "+Arrays.deepEquals(ary1D, ary1D2));
    }
    
}
