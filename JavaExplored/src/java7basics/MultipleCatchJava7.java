/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

/**
 *
 * @author hacker
 */
public class MultipleCatchJava7 {
    
    public static void main (String[] args){
        try {
            String str = null;
            if (str.equals("null")) {
                throw (new NullPointerException());
            }
            else {
                throw (new ArrayIndexOutOfBoundsException());
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException ex) {
            System.out.println("exception");
            ex.printStackTrace();
           
        
        }
    }
}

