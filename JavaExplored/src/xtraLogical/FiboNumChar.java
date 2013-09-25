
package xtraLogical;

import java.math.BigInteger;

/**
 * http://www.hacker-olympics.com/puzzle.html 
 * @author hacker
 */

public class FiboNumChar {
    
    public static void main(String[] args) {
        
        StringBuilder result = new StringBuilder("");
        BigInteger f = new BigInteger("0");
        BigInteger t= new BigInteger("1");
        
        int i=-1;
       
        while(i++<500){
            System.out.println(i+"- "+f);
            if(i%2==0){
                BigInteger vowel = new BigInteger("0");
                if(f.compareTo(new BigInteger("26"))>0){
                    vowel = f.mod(new BigInteger("26"));
                    
                    if((vowel.equals(new BigInteger("1"))) || (vowel.equals(new BigInteger("5"))) || (vowel.equals(new BigInteger("9"))) || (vowel.equals(new BigInteger("15"))) || (vowel.equals(new BigInteger("21")))){
                       
                        result = result.append((char)(96+vowel.intValue()));
                        
                    }
                }
                else{
                  
                    if((f.equals(new BigInteger("1"))) | (f.equals(new BigInteger("5"))) | (f.equals(new BigInteger("9"))) | (f.equals(new BigInteger("15"))) | (f.equals(new BigInteger("21")))){
                     
                        result = result.append((char)(96+f.intValue()));
                       
                    }
                }
            }
            t= f.add((f=t));
            
            
        }
        
        System.out.println(" vowels in fibo = \n " + result);
        
    }

}
