/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtraLogical;

/**
 *
 * @author hacker
 */
public class ShortestFibboCode {
    
    public static void main(String... args){
        
        int currentFibo=0;
        int nextFibo=1;
        
        while(currentFibo<5){
            System.out.print(currentFibo + " ");
            
            nextFibo=currentFibo+(currentFibo=nextFibo);
        }
    }
}

