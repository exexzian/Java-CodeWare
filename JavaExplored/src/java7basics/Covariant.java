/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

import java.util.concurrent.Future;


class Parent 
{ 
         Parent sampleMethod() 
         {
              System.out.println("Parent sampleMethod() invoked");
              return this; 
         }
}

class Child extends Parent 
{ 
    
    int a;
    String name;
    
    @Override
         Child sampleMethod() 
         {
                System.out.println("Child sampleMethod() invoked");
                return this; 
         } 

}

public class Covariant 
{
         public static void main(String args[]) 
         { 
             Child child1 = new Child();
             Child child2 = child1.sampleMethod();
             Parent parent1 = child1.sampleMethod();
             Parent pObj = new Parent();
             pObj.sampleMethod();
         }
}


