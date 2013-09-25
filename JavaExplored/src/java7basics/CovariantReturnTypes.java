/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

class baseCls{
      
    public baseCls() {
        System.out.println("base:constructor");
    }
    
    public void show(){
        System.out.println("in base class");
    }
}

class childCls extends baseCls{
    
    public childCls() {
        System.out.println("child:constructor");
    }
    
    @Override
    public void show(){
        System.out.println("in child class");
    }
    
    public baseCls coReturn(){
        System.out.println("in covariant return method of child");
        
        return new childCls();
    }
    

}

public class CovariantReturnTypes {
    
    public int fun(){
        
        return 1;
    }
    
    public static void main(String[] args) {
        
        childCls cObj = new childCls();
        cObj.coReturn();
    }
}
