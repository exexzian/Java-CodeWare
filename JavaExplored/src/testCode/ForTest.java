/*
 * http://stackoverflow.com/questions/14487845/compare-two-strings-that-are-lexicographically-equivalent-but-not-identical-at-t#14488004
 */
package testCode;

import java.util.regex.Pattern;

class ForTest {

    public static void main(String[] args) {

        int space, n = 4, i, c, k,temp=1;
        space = n - 1;

        for (k = 1; k <= n; k++) {
            for (c = 1; c <= space; c++) {
                System.out.print(" ");
                temp++;
            }

            space--;

            for (c = 1; c <= 2 * k - 1; c++) {
                System.out.print("*");
                temp++;
            }

            System.out.println("");
        }

        space = 1;

        for (k = 1; k <= n; k++) {
            for (c = 1; c < space; c++) {
                System.out.print(" ");
                temp++;
            }

            space++;

            for (c = 2 * k - 1; c <= 2 * n - 1; c++) {
                System.out.print("*");
                temp++;
            }

            System.out.println("");

        }
        
        System.out.println("temp = "+temp);
    }
}
