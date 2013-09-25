/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logics;

import java.util.HashMap;

public class FrequencyCount {

    public static void main(String[] args) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        String s = "aasjjikkk";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer val = map.get(c);
            if (val != null) {
                map.put(c, (val + 1));
            } else {
                map.put(c, 1);
            }
        }
        for (Character key : map.keySet()) {
            System.out.println("------------------------------------------------");
            System.out.println("Iterating or looping map using java5 foreach loop");
            System.out.println("key: " + key + " value: " + map.get(key));
        }

    }
}
