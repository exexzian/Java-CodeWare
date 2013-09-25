/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexplored;


/* Ways to prevent Inheriance
 * 1. Declare Class Final
 * 2. Declare Class Constructor Private
 * 3. Following Method
 *
 */
class NonInheritable{
    
    public NonInheritable() {
        if(this.getClass()!= NonInheritable.class)  // if obj instantiating this class is any other than
                                                       // this NonInheritable Class then throw Runtime Excep                     
            throw new RuntimeException("Subclass not Allowed");
    }

}

class PreventInheritance extends NonInheritable{
    
    public static void main(String[] args) {
        
        new PreventInheritance();
        
    }
}
