package javaexplored;

import testCode.*;


/**
 * http://crazyprogrammer.wordpress.com/2009/10/30/print-a-diamond-shape-using-asterisks-in-c/
 * @author hacker
 */


class RecursiveTryFinally {
    static int i;
    
   void foo(){
       System.out.println(i++ +"=foo");
       try {
           foo();
       } 
       catch(Exception e){
       e.printStackTrace();
       }
       finally {
           foo();
           
       }
   }
   
   void bar(){
       System.out.println("bar");
       try {
       bar();    
       } catch (Exception e) {
       e.printStackTrace();
       }
       
   }
   
    
    public static void main(String[] args) {
        
//       new ForTest().bar();
        new RecursiveTryFinally().foo();
    }

}