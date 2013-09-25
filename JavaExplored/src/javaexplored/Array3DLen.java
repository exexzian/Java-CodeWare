/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexplored;

/**
 *
 * @author hacker
 */
public class Array3DLen {
    /**
     * 
     * @param args 
     */
    public static void main(final String[] args) {
        int arr[][][]= {{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}},
            {{11,12,13,14},{15,16,17,18},{19,110,111,112},{113,114,115,117}}};
        
        System.out.println("arr len = " + arr.length); //number of array Blocks
        System.out.println("arr len[] = " + arr[1].length); // number of arrays in that array block
        System.out.println("arr len[][] = " + arr[0][3].length); // number of columns in 1D array
        System.out.println(" 01 = " + arr[0][0][1]);
        
        for(int a=0; a<arr.length; a++){
            for(int b=0; b<arr[a].length; b++){
                for(int c=0; c<arr[a][b].length; c++){
                    System.out.print(arr[a][b][c]+"\t");
                }
                System.out.println();
            }
        }
    }
}
