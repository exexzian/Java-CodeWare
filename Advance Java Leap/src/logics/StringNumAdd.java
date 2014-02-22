/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logics;

/**
 *
 * @author bingo
 */
public class StringNumAdd {

    public static String addStringNum(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (true) {
            int i1 = i < 0 ? 0 : Character.digit(a.charAt(i), 10);
            int i2 = j < 0 ? 0 : Character.digit(b.charAt(j), 10);
            int i3 = i1 + i2 + carry;
            if (i3 > 9) {
                carry = 1;
                i3 -= 10;
            } else {
                carry = 0;
            }
            sb.append(i3);
            i--;
            j--;
            if (i < 0 && j < 0) {
                sb.append(carry);
                break;
            }
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        String a = "9234567899";
        String b = "123456789";
        
       String result =  addStringNum(a, b);
        System.out.println(" result = " + result);
        
    }
}
