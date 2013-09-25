/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexplored;

 class TryCatchFinallyTest implements Runnable {
    
    private void testMethod() throws InterruptedException
    {
        try
        {
            System.out.println("In try block");
            throw new NullPointerException();
        }
        catch(NullPointerException npe)
        {
            System.out.println("In catch block");
        }
        finally
        {
            System.out.println("In finally block");
        }
    }
    
    @Override
    protected void finalize() throws Throwable {
        System.out.println("********In finalize block*********");
        super.finalize();
    }
    
    @Override
    public void run() {
        try {
            testMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class ForceFinalize {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        
        for(int i=1;i<=3;i++){
            new Thread(new TryCatchFinallyTest()).start();
            
             // calls Finalize forcefully otherwise its call is not guaranteed
            Runtime.runFinalizersOnExit(true); 
        
        }
    
    }

}
