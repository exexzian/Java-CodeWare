/*
 * http://stackoverflow.com/questions/14487845/compare-two-strings-that-are-lexicographically-equivalent-but-not-identical-at-t#14488004
 */
package java7basics;

import testCode.*;

class ThreadSyncRun implements Runnable{
    public static void main(String[] args) {
        
        ThreadSyncRun o = new ThreadSyncRun();
        ThreadSyncRun o2 = new ThreadSyncRun();
        
        System.out.println("A");
        Thread T=new Thread(o);
        Thread T1=new Thread(o);
        System.out.println("B");
        T.setName("thread 1");
        T1.setName("thread 2");
        System.out.println("C");
        T.start();
        System.out.println("D");
        T1.start();
    }
    
    
    @Override
    synchronized public void run()
    {
        for(int i=0; i<3; i++)
        {
            try
            {
                System.out.println("Inside run=>"+Thread.currentThread().getName());
                Thread.sleep(500);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

