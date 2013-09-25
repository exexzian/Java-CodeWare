/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cdacLab;

/**
 *
 * @author hacker
 */
public class Pattern2_New {
    
    public static void main(String[] args) {
        
        final long startTime = System.nanoTime();
        
        int n=5;
        char ch = 'A';
        for (int i = 1; i <=5; i++) {
            ch='A';
            for (int j = 1; j <n ; j++) {
                System.out.print("\t");
            }
            n--;
            for (int k = 1; k <(2*i); k++) {
                if(i==1){
                    System.out.print(ch);
                }
                else{
                    if(k<i){
                        System.out.print(ch++ + "\t");
                    }
                    
                    if(k>=i){
                        System.out.print(ch-- + "\t");
                    }
                    
                }
            }
            System.out.println("");
            
            
        }
        final long duration = System.nanoTime() - startTime;
        System.out.println("running time - "+duration +" nano-sec");
    }
}