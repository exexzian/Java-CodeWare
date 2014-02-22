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
public class CheckCreditCardNum {

    public static void main(String[] args) {
        String cardNum = "126345678";
        String temp = null;
        boolean isValid = false;

        for (int i = 0; i < cardNum.length() - 1; i++) {
            temp = "";
            temp += cardNum.substring(0, i) + cardNum.substring(i + 1, cardNum.length());
            System.out.println(temp + "  " + cardNum.charAt(i));

            isValid = isCardValid(temp, cardNum.charAt(i));
            
            if (isValid) {
                System.out.println("Valid Credit Card Number");
                break;
            } 
        }
        System.out.println("Invalid Credit Card Number");

    }

    public static boolean isCardValid(String cardNum, char current) {
        boolean isValid = false;
        int sum = 0;

        for (int i = 0; i < cardNum.length(); i++) {
            sum += Integer.parseInt(String.valueOf(cardNum.charAt(i)));
        }

        System.out.println("sum = " + sum);

        if (Character.getNumericValue(current) == sum % 10) {
            return true;
        } else {
            return false;
        }
    }

}
