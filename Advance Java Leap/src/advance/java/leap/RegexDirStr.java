/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advance.java.leap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bingo
 */

public class RegexDirStr {

    int a ;
   
    public static void main(String[] args) {
        final Pattern p = Pattern.compile("[^/]/");
        final String s = "/accounts/main/index/page.xhtml";
        final Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(s.substring(0, m.end()));
        }
    }
    
}
