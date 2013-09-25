/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexplored;

/**
 *http://java.dzone.com/articles/why-does-void-class-exist-jdk
 * 
 */


 class VoidWrapper {
 public static void main(String[] args) throws SecurityException, NoSuchMethodException {
  Class c1 = Test1.class.getMethod("Testt",null).getReturnType();
  System.out.println(c1 == Void.TYPE);
  System.out.println(c1 == Void.class);
 }
}
 
class Test1{
 public void Testt(){
 
 }
}