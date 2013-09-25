package advance.java.leap;



/**
 * POLYMORPHISM - DYNAMIC DISPATCHER
 * http://stackoverflow.com/questions/18913202/what-are-the-rules-for-dynamic-dispatching-in-c#18913349
 * @
 */
class GrandClass {

    public void op(int x, double y) {
        System.out.println("a");
    }

    public void op(double x, double y) {
        System.out.println("b");
    }
}

class ParentClass extends GrandClass {

    @Override
    public void op(int  x, double y) {
        System.out.println("c");
    }

    public void op(int x, int y) {
        System.out.println("d");
    }
}

class Child extends ParentClass {

    @Override
    public void op(int x, int y) {
        System.out.println("e");
    }
}

public class PolymorphismDynamicDispatcher {

    public static void main(String[] args) {
        GrandClass a = new Child();
        ParentClass b = new Child();

         a.op(2, 4);
         b.op(2.0, 4.0);
    }
}
