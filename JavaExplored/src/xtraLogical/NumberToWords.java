/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtraLogical;

import javax.swing.JOptionPane;

public class NumberToWords {
    
    static String[] elms = { "zero", "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine" };
    static String[] deci = { "ten", "eleven", "twelve", "thirteen", "fourteen",
        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
    static String[] tens = { "zero", "ten", "twenty", "thirty", "fourty",
        "fifty", "sixty", "seventy", "eighty", "ninety" };
    static String[] mark = { "", "thousand", "million", "billion" };
    
    public static String toWords(int numb) {
        int hun = numb / 100;
        int rest = numb % 100;
        String result = "";
        if (hun != 0) {
            result += elms[hun] + "hundred ";
        }
        int dec = rest / 10;
        int nRest = rest % 10;
        if (dec > 1) {
            result += tens[dec];
            if (nRest != 0)
                result += elms[nRest];
        } else if (dec == 1)
            result += deci[nRest];
        else if (dec == 0 && nRest != 0)
            result += elms[nRest];
        return result;
    }
    
    public static void main(String[] args) {
        String number = JOptionPane.showInputDialog("Enter a number");
        String toMark;
        int numb = 0;
        String result = "";
        if (number.length() < 4) {
            numb = Integer.parseInt("number");
            result = toWords(numb);
        } else {
            int marker = 0;
            while (number.length() > 0) {
                String n = "";
                if (number.length() >= 3) {
                    n = number.substring(number.length() - 3, number.length());
                    number = number.substring(0, number.length() - 3);
                } else {
                    int l = number.length();
                    n = number.substring(number.length() - l, number.length());
                    number = number.substring(0, number.length() - l);
                }
                numb = Integer.parseInt(n);
                toMark = " " + mark[marker];
                if (toWords(numb).equals("")) {
                    toMark = "";
                }
                result = toWords(numb) + toMark + " " + result;
                marker += 1;
            }
        }
        
        System.out.println(result);
    }

}