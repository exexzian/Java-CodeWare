/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SomeRunnable implements Runnable {
    
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println("Counter - " + i + " / Thread Name : "
                    + Thread.currentThread().getName()+ " - " + this);
        }
    }
}

public class ExecutorDemo {
    public static void main(String[] args) {
        //Create objects of Runnable
        SomeRunnable obj1 = new SomeRunnable();
        SomeRunnable obj2 = new SomeRunnable();
        SomeRunnable obj3 = new SomeRunnable();
        
        System.out.println("obj1 = "+obj1);
        System.out.println("obj2 = "+obj2);
        System.out.println("obj3 = "+obj3);
        
        //Create fixed Thread pool, here pool of 2 thread will created
        ExecutorService pool = Executors.newFixedThreadPool(3);
        ExecutorService pool2 = Executors.newFixedThreadPool(2);
        pool.execute(obj1);
        pool.execute(obj2);
        pool2.execute(obj3);
        
        pool.shutdown();
        pool2.shutdown();
    }

}
