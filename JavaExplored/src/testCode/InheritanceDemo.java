/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

public class InheritanceDemo {

    public static void main(String[] args) {

        ParentClass p = new ParentClass();
        ChildClass c = new ChildClass();

        //Casting ChildClass to ParentClass
        ParentClass pc = new ChildClass();
        pc.parentClassMethod(); //Output: Parent Class Method (as expected)

        //Again Casting Parent Class to ChildClass explictly
        //Question 1 for this code
        ChildClass cp = (ChildClass) pc;
        cp.parentClassMethod(); //Output: Parent Class Method (unexpected)

        ChildClass cc1 = (ChildClass) new ParentClass();
       // cc1.parentClassMethod(); //Compiles, but Run Time Error

       // ChildClass cc2 = (ChildClass) p;
      //  cc2.parentClassMethod(); //Compiles, but Run Time Error

    }
}

class ParentClass {

    public void parentClassMethod(){
        System.out.println("Parent Class Method");
    }

}

class ChildClass extends ParentClass {

    @Override
    public void parentClassMethod(){
        System.out.println("Parent Class Method From Child Class");
    }

    
}