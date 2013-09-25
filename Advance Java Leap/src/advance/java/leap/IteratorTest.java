/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advance.java.leap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author bingo
 */
public class IteratorTest {

    public static void main(String args[]) {

        //creating HashSet to iterate over
        Set<String> streams = new HashSet<String>();
        streams.add("Programming");
        streams.add("Development");
        streams.add("Debugging");
        streams.add("Coding");
        
        final long startTime = System.nanoTime();
        // Iterating over HashSet in Java using for-each loop
        for (String str : streams) {
            System.out.println(" Looping over HashSet in Java element : " + str);
        }
        final long duration = System.nanoTime() - startTime;
        System.out.println("---------------------------------------- \n Time 1 = " + duration);
        
        final long startTime2 = System.nanoTime();
        //Iterating over HashSet using Iterator in Java
        Iterator<String> itr = streams.iterator();
        while (itr.hasNext()) {
            System.out.println(" Iterating over HashSet in Java current object: " + itr.next());
        }
         final long duration2 = System.nanoTime() - startTime2;
        System.out.println("---------------------------------------- \n Time 1 = " + duration2);
        

    }
}
