/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexplored;


/**
 *
 * @author hacker
 */

class SingeltonClass{

    private static SingeltonClass singObj;
    
    private SingeltonClass() {
    }
    
    public static synchronized SingeltonClass getSingObj(){
        if(singObj==null){
            singObj = new SingeltonClass();
            
        }
        return singObj;
    }
    public void fun(){
        System.out.println("in fun");
    }
}
    


  class SingeltonWays {
    
    public static void main(String[] args) {
        SingeltonClass tempObj = SingeltonClass.getSingObj();
        tempObj.fun();
        
        // not allowed
//        SingeltonClass obj = new SingeltonClass();
        
        
    }
    
    

}
