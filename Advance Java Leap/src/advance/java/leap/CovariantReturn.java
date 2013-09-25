/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package advance.java.leap;

class Base{
    public Base foo(){
            System.out.println("in Base foo");
            return new Base();
    }
}

class Derived extends Base{
    
    @Override
    public Derived foo(){
        System.out.println("in Derived foo");
        return new Derived();
    }
}
public class CovariantReturn {
    public static void main(String[] args) {
        Base obj = new Derived();
        obj.foo();
    }
}
