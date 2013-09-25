package javaexplored;

import testCode.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * http://www.opentaps.org/docs/index.php/How_to_Use_Java_BigDecimal:_A_Tutorial
 * It is important to never use the .equals() method to compare BigDecimals. That is because this equals function will compare the scale. If the scale is different, .equals() will return false, even if they are the same number mathematically.
 BigDecimal a = new BigDecimal("2.00");
 BigDecimal b = new BigDecimal("2.0");
 print(a.equals(b)); // false
  Instead, we should use the .compareTo() and .signum() methods.
 a.compareTo(b);  // returns (-1 if a < b), (0 if a == b), (1 if a > b)
 a.signum(); // returns (-1 if a < 0), (0 if a == 0), (1 if a > 0)
 */


class BigDecimalCompare {
   
    public static void main(String[] args) {
        
    BigDecimal b = new BigDecimal("2.00");
    BigDecimal b2 = new BigDecimal("2.0");
    //If the scale is different, .equals() will return false, even if they are the same number mathematically.
        System.out.println(" using equals = " + b.equals(b2));
        System.out.println("using compareTo = "+b.compareTo(b2));
    }

}