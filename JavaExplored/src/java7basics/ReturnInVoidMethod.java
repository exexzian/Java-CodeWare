package java7basics;


import java.util.Scanner;

class ReturnInVoidMethod  {
    
    public void fun(){
        
        System.out.println("hahha");
        int i=1;
        while(i<5){
            System.out.println(i++);
            if(i==3){
                return;
            }
        }
        
    }
    
   
    public static void main(String[] args) {
       
       new ReturnInVoidMethod().fun();
    
    }

}


