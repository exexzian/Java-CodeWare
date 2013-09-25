/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

 class PLoop {

    // instance variable
    public int[] memList;

    // method 1
    public void memPass(int[] memLocList) {

        memList = memLocList;
        System.out.println(memList.length);
    }

    // method 2
    public void accessArray() {

        System.out.println(memList.length);
    }
}

 class ArrayAcess{
    
     public static void main(String[] args) {
         
         int[] aryPassed = {1,2,3};
         PLoop obj = new PLoop();
         PLoop obj2 = new PLoop();
         obj.memPass(aryPassed);
         obj2.accessArray();  //NPEx
         
     }
    
}