/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

import java.lang.reflect.Method;

public class ReflectionExtra {
    
    
    private static int counter = 0;
    private static long time = 0;
    
    private int var;
    
    public ReflectionExtra(int varP) {
        var = varP;
    }
    
    public static void main(String[] args) throws Exception {
        
        ReflectionExtra exec = new ReflectionExtra(4);
        Object obj = exec;
        int TUNRS = 1000000;
        
        //1
        time = System.currentTimeMillis();
        for (int i = 0; i < TUNRS; i++) {
            exec.calc();
        }
        printTime("direct call time");
        
        //2
        time = System.currentTimeMillis();
        for (int i = 0; i < TUNRS; i++) {
            Method increment = ReflectionExtra.class.getMethod("calc");
            increment.invoke(obj);
        }
        printTime("reflection time");
        
        //3, with optimization
        time = System.currentTimeMillis();
        Method increment = null;
        increment = ReflectionExtra.class.getMethod("calc");
        for (int i = 0; i < TUNRS; i++) {
            increment.invoke(obj);
        }
        printTime("reflection (optimized) time");
    
    }
    
    public void calc() {
        //complicated code which is not optimized by JIT
        counter = counter + var - (var / 2) - (var / 2);
    }
    
    private static void printTime(String message) {
        long length = System.currentTimeMillis() - time;
        System.out.println(message + " = " + length + " msec.");
    }

}
