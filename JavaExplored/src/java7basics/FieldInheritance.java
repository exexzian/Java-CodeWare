/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

class A {
    String s1 = "A.s1";
    String s2 = "A.s2";
    String str = "bye";
    void t1() {
        System.out.println("IN CLASS A");
    }

} 

class FieldInheritance extends A {
    
        String s1 = "ChildCLass.s1";
        String s2 = "ChildClass.s2";
        
        void t1() {
            System.out.println("IN Child CLASS ");
            System.out.println(super.s1);
        } 
        
        public static void main(String args[]) {
            FieldInheritance x = new FieldInheritance();
            
            System.out.println("str = "+x.str);
            
            A y = (A) x;
            A z = new FieldInheritance();
            System.out.println(x.s1 + " " + x.s2 + " " + y.s1 + " " + y.s2);
            System.out.println(z.s1 + " " + z.s2);
            z.t1();
            x.t1();
            y.t1();
            
        }
    }