package advance.java.leap;

/**
 *  Declaring multiple arrays with 64 elements 1000* faster than declaring array of 65 elements
 * sources:
 * http://stackoverflow.com/questions/18810505/declaring-multiple-arrays-with-64-elements-1000-faster-than-declaring-array-of
 * 
 * http://en.wikipedia.org/wiki/Escape_analysis
 * http://www.ibm.com/developerworks/java/library/j-jtp09275/index.html
 * http://www.javaspecialists.eu/archive/Issue179.html
 * 
 * 
 */
public class ObjectEscapeAnalysis {
   
    public static void main(String[] args)  {
               
        long start = System.nanoTime();
        int job = 100_000;//100 million
        for (int i = 0; i < job; i++) {
            //try with 64 and 65 - 65+ object creation takes more time
            // coz of escape analysis - Less than 65 objects gets created on stack frame
            ObjectEscapeAnalysis[] test = new ObjectEscapeAnalysis[64];  
            // int[] intObj = new int[65];
        }
        long end = System.nanoTime();
        System.out.println("Total runtime = " + (end - start) / 1000000 + " ms");
       
    }

}