/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtraLogical;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author hacker
 */
public class WordFrequency {
   // @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        
        String text = "hello bye hello a bb a bye hello";
        
        List<String> list = Arrays.asList(text.split(" "));
        
        Set<String> uniqueWords = new HashSet<String> (list);
        for (String word : uniqueWords) {
            System.out.println(word + ": " + Collections.frequency(list, word));
        }
    }
    
    

}
