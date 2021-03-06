/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

/*
 * https://blogs.oracle.com/CoreJavaTechTips/entry/get_netbeans_6
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CallableExample {
    
    public static class WordLengthCallable implements Callable {
        private String word;
        public WordLengthCallable(String word) {
            this.word = word;
        }
        public Integer call() {
            return Integer.valueOf(word.length());
        }
    }
    
    public static void main(String args[]) throws Exception {
        
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set<Future<Integer>> set = new HashSet<Future<Integer>>();
        
        String[] callStr = {"ac", "boom", "crewq", "dog", "e"};
        
        for (String word: callStr) {
            Callable<Integer> callable = new WordLengthCallable(word);
            Future<Integer> future = pool.submit(callable);
            
            set.add(future);
        }
                
        int sum = 0;
        for (Future<Integer> future : set) {
            System.out.println("future get = "+future.get());
            sum += future.get();
        }
        System.out.printf("The sum of lengths is %s%n", sum);
        System.exit(sum);
    }
}