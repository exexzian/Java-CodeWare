/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

/**
 *
 * @author hacker
 */

public class OverloadVarArgs {
    
    
    public void fun(Integer a,Integer b){
        System.out.println("Integer with two Parameters" );
    }
    
    public void fun(Integer... a){
        System.out.println("Integer with var args");
    }
    
    public void fun(int a,int b){
        System.out.println("int with two parameters");
    }
    
    public void fun(int... a){
        System.out.println("int with var args");
    }
    
    public static void main(String[] args) {
        new OverloadVarArgs().fun(1,2);
    }
}
