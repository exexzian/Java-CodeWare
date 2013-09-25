/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexplored;

/**
 * http://www.javarocks.in/finalization/
 * http://java2learn.com/?page_id=168
 * 
 * @author hacker
 */

class FinalizeContract{
    
    public static void main(String arg[])
    {
        FinalizeContract s = new FinalizeContract();
        //s.finalize(); // calling explicitly causes runtime exception
        s = null;
        System.gc();
        System.out.println("End of main method");
    }
    public void finalize()
    {
        System.out.println("finalize method");
        System.out.println(10/0);
    }

}

