/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advance.java.leap;

public class ThreadTest {
    public static void main(String[] args) {

        ThreadTest threadTest = new ThreadTest();
        threadTest.m1();
        synchronized (threadTest) {
            System.out.println("sync block " + " b4 m2");
            
            threadTest.m2();
            
            System.out.println("sync block " + " after m2");
        }
        System.out.println("End of main thread");
    }

    public void m1() {
        Thread myThread = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("m1 = " + Thread.currentThread().getName() + " : " + i);
                }
                System.out.println("end of mythread");
            }
        });
        myThread.start();
    }

    public void m2() {
        for (int i = 0; i < 10; i++) {
            System.out.println("m2 = " + Thread.currentThread().getName() + " : " + i);
        }
    }

}
