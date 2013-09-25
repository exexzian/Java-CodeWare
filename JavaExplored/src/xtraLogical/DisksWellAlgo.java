/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtraLogical;

import java.util.Scanner;

/**
 *http://stackoverflow.com/questions/14285930/given-an-array-of-best-fit-sizes-tell-how-many-elements-from-the-other-array-c
 * @author hacker
 */
public class DisksWellAlgo {
    public static void main(String[] args) {
        int nWell,nDisks,level=0;
        Scanner sc = new Scanner(System.in);
        
        int count=0;
        int well[] = {5,7,4,3,2,2,3};
        int disk[] = {3,2,3,4};
//        nWell = sc.nextInt();
//        nDisks = sc.nextInt();
//        
//        int well[] = new int[nWell];
//        int disk[] = new int[nDisks];
//      
        
        level = well.length;
        int times=0;
        diskLoop:
        for (int d = 0; d < disk.length; d++) {
            times++;
            wellLoop:
            for (int w = 0; w <level;) {
                times++;
                if(disk[d]<=well[w]){
                    if(w==level-1){
                        count++;
                        level = level-1;
                        break wellLoop;
                    }
                    else{
                    w++;
                    }
                }
                else{
                    level = w;
                    count++;
                    break wellLoop;
                }
                                
            }
            if(level-1==0){
                break diskLoop;
            }
        }
        
        System.out.println("count = " + count +"\n times = "+times);
        
        
    }
}
