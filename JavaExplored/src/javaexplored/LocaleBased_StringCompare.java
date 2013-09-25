/*
 * http://stackoverflow.com/questions/14487845/compare-two-strings-that-are-lexicographically-equivalent-but-not-identical-at-t#14488004
 */
package javaexplored;

import java.io.UnsupportedEncodingException;
import java.text.Collator;

class LocaleBased_StringCompare{
    
    public static void main(String... arg) throws UnsupportedEncodingException
    {
        byte[] ch = {98, 97, 97, 97, -61, -87, 46, 112, 110, 103};
        byte[] ff = {98, 97, 97, 97, 101, -52, -127, 46, 112, 110, 103};
        
        String st = new String(ch,"UTF-8");
        String st2 = new String(ff,"UTF-8");
        System.out.println(st);
        System.out.println(st2);
        System.out.println(st.equals(st2));
        
        Collator usCollator = Collator.getInstance();
        usCollator.setStrength(Collator.TERTIARY);
        System.out.println(usCollator.equals(st, st2));
    }

}

