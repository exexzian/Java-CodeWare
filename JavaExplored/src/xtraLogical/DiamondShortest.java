package xtraLogical;

import testCode.*;

/**
 * http://crazyprogrammer.wordpress.com/2009/10/30/print-a-diamond-shape-using-asterisks-in-c/
 * @author hacker
 */

class DiamondShortest{
    
    public static void main(String[] args) {
        
        int i=0, j=0, NUM=3;
        
        for(i=-NUM; i<=NUM; i++)
        
        {
            
            for(j=-NUM; j<=NUM; j++)
            
            {
                if( Math.abs(i)+Math.abs(j)<=NUM) // Change this condition
               {
                    System.out.print("*"); 
                }
                
                else {
                    System.out.print(" ");
                }
            
            }
            
            System.out.println("");
        
        }
        
    }
}