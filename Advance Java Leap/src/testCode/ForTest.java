package testCode;

/**
 * POLYMORPHISM - DYNAMIC DISPATCHER
 * http://stackoverflow.com/questions/18913202/what-are-the-rules-for-dynamic-dispatching-in-c#18913349
 * @
 */

public class ForTest {

    static int a = 2;
    int b = 10;
    void fun(){
        a = 3;
        b = 20;
    }
    
    static void sun(){
        a = 4;
    }
    
    public static void main(String[] args) {
        System.out.println(" a = " +a);
        System.out.println("b = " + new ForTest().b);
    }
}
