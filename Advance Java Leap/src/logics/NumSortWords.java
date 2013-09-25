/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logics;

/**
 *
 * @author bingo
 */
public class NumSortWords {
    
    static int[] insertionSort(int ary[]){
        
        int i,j,n;
        for ( i = 1; i < ary.length; i++) {
            n=ary[i];
            for ( j = i-1; j >=0 && ary[j]>n; j--) {                              
                ary[j+1] = ary[j];                
            }
            ary[j+1] = n;
        }
        System.out.println("sorted array - ");
        for (int k = 0; k < ary.length; k++) {
            System.out.print(ary[k] + ", ");
           
       }
        return ary;
    }
   
   
    
    
    public static void main(String[] args) {
        int[] ary = {12,3423,2,34,345};
        
        ary = insertionSort(ary);
        
        String[] digits = {
                            "zero", "one", "two", "three", "four", 
                            "five", "six", "seven", "eight", "nine"
                         };
        
       // String strNums = Arrays.toString(ary);
       // String numAry[] = strNums.substring(1,strNums.length()-1).split(", ");
       // System.out.println("= " + strNums);
               
      //  System.out.println("strings = " + Arrays.toString(numAry));
        
        String numAry2[] = new String[ary.length];
        for (int i = 0; i < ary.length; i++) {            
            numAry2[i] = Integer.toString(ary[i]);            
        }
        
        System.out.println("\n---------------");
        for (int i = 0; i < numAry2.length; i++) {
            
            for (int j = 0; j < numAry2[i].length(); j++) {
              
                System.out.print(digits[Integer.parseInt(Character.toString(numAry2[i].charAt(j)))] + " ");
           
            }
            if(i!=numAry2.length-1){
            System.out.print(", ");
            }
        }
    }
}
