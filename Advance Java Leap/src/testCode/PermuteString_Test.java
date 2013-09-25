/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

/**
 *
 * @author bingo
 */
public class PermuteString_Test {

    public static void main(String args[]) {
        permuteString("", "abc");
    }

    public static void permuteString(String beginningString, String endingString) {
        if (endingString.length() <= 1) {
            System.out.println(beginningString + endingString);
        } else {
            for (int i = 0; i < endingString.length(); i++) {
                try {
                    String newString = endingString.substring(0, i) + endingString.substring(i + 1);
                    System.out.println("\t\t "+ i + " - new string = " + newString);
                    permuteString(beginningString + endingString.charAt(i), newString);
                } catch (StringIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
