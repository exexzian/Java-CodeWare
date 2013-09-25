package javaexplored;

/*
 * http://way2java.com/exceptions/classcastexception/
 *
 */
class Parent{
    void call(){
        System.out.println("in pareny call");
    }
    void prnt(){
        int a;
        a=10;
        System.out.println("only of parent - " + a);
    }
}

class Child extends Parent{
    @Override
    void call(){
        System.out.println("in child call");
    }
    void foo(){
        System.out.println("in Child foo");
    }
}

public class Casting{
    public static void main(String[] args) {
        
        // upcasting is done automatically as :
        Parent a=  new Child(); // both of these code are same - Parent a = (Parent) new Child();
        //a.foo();// compile time error as parent type 'a' doesn't have the access to child method
        
        //Child c = (Child) new Parent(); // downcastng compiles bt runtime exception - as A subclass variable
        //cannot hold a reference to a superclass  variable.
        
        //c.foo(); // runtime exception as in Parents Class memory there is no foo() method
        a.call(); // successful as Parent class also has call method
        
        Parent p1 = new Parent();
        Child c1 = (Child) p1; // runtime exception
        
        //valid downcasting process
        Child b=new Child();
        b.foo();  // compiles and executes no casting done
        b.prnt(); // success coz of inheritance
        Parent p2 = b;  // (UPCASTING)
        Child c2 = (Child) p2; // (valid DOWNCASTING)
        System.out.println("nw calling after downcasting");
        c2.foo();
        /*********************************************************/
        System.out.println("----------concept - when downcasting is permitted----------");
        Object o = "a String";
        String s = (String) o; // this will work, since o references a String
        System.out.println("object downcasted to string = " + s);
        
        Integer i = 23;
        // String s = (String) i; // the compiler will not allow this, since i can never reference a String.
        
        String s2 = "some string";
        Object o2 = s2; // (UPCASTING) ok same as Object o2 = (Object) s2;
        //String x = o2; // gives compile-time error, o2 is not necessarily a string
        String x = (String)o2; // ok compile-time, but might give a runtime exception if o is not infact a String
        if(o instanceof String) {
            System.out.println("yes 'o' is an instance of String, so it can b downcasted to string --- " +x);
        }
        
        
        
    
    }
}