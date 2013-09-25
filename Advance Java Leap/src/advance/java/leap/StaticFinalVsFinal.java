package advance.java.leap;

import testCode.*;

public class StaticFinalVsFinal {

    // usual way to declare constants statically
    final int a = 10;
    static final int b = 20;

    // dynamically initializing final variables
    public final int finalVariable;
    public static final int staticFinalVariable;

    /**
     * static finals can be initialized in static block as well
     */
    static {
        staticFinalVariable = (int) (Math.random() * 100);
    }

    /**
     * final variables (not static) can be initialized in constructor as well
     *
     */
    public StaticFinalVsFinal(int finalVariable) {
        this.finalVariable = finalVariable;
    }

    public static void main(String[] args) {
        // now using this each object can have its own copy of final variable with different final values
        StaticFinalVsFinal obj1 = new StaticFinalVsFinal(5);
        StaticFinalVsFinal obj2 = new StaticFinalVsFinal(10);
        System.out.println("Normal Final variable (Per object)");
        System.out.println("obj1 final variable value = " + obj1.finalVariable);
        System.out.println("obj1 final variable value = " + obj2.finalVariable);

        System.out.println("\nStatic final variable (Per Class)= " + StaticFinalVsFinal.staticFinalVariable);
        // following ones after compilation gets resolved to ForTest.staticFinalVariable
        System.out.println("obj1.staticFinalVariable= " + obj1.staticFinalVariable);
        System.out.println("obj2.staticFinalVariable= " + obj2.staticFinalVariable);

    }

}