package java7basics;

/**
 * Represents that Static method though inherited cannot be over-ridden but gets
 * bind to child class thus, static method with same name defined in child class
 * is completely different from that of the method already defined in parent
 * class
 *
 */
class ParentStatic {

    static String str = "Parent Static Variable";

    public static void hiddenStaticParent() {
        System.out.println("Parent: hidden static method - static method is though inherited cannot be over-ridden but gets bind to sub-class so hidden");
    }

    static void staticMethodPar() {
        System.out.println("Parent: Static Method");
    }

    void nonStaticPar() {
        System.out.println("Parent: non static method");
    }

}

class StaticHidden_SubClass extends ParentStatic {

    public static void staticMethodPar() {
        System.out.println(str + "\nChild: static method - same name as of parent class method");
    }

    @Override
    void nonStaticPar() {
        System.out.println("overridden child: non static method");
    }

    Integer outInt;

    {
        outInt = Integer.valueOf(5);
    }

    public static void main(String[] args) {

        // parent class invoking static method
        ParentStatic.staticMethodPar();
        // though with same name - statc method is not inherited so this
        // static method of child class is different than that of parent class
        StaticHidden_SubClass.staticMethodPar();

        System.out.println("-------------------------------------------------------------");
        //invoking static method of parent class
        ParentStatic.hiddenStaticParent();
        //accessing static method of parent class hidden inside child class
        StaticHidden_SubClass.hiddenStaticParent();
        System.out.println("-------------------------------------------------------------");

        StaticHidden_SubClass childObj = new StaticHidden_SubClass();
        ParentStatic parentObj = new ParentStatic();

        parentObj.nonStaticPar();
        childObj.nonStaticPar();

        parentObj = childObj;
        parentObj.nonStaticPar();

    }

}
