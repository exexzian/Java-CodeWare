
package java7basics;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;



/*
 * http://java.sun.com/developer/technicalArticles/ALT/Reflection/
 * http://www.cognitus.net/html/tutorial/reflection/sec_1_3.html
 */

 interface InterfaceReflect{
    public static final int irA=50;
    
    public void interfaceMethod();
    
} 

class ParentReflection{
    
    private int pInt;
    public String pStr;
    public static float pFloat;
    protected float dpFloat;

    public ParentReflection() {
        System.out.println("Parent Constructor");
    }
    
    public void publicParentMethod() {
        System.out.println("public parent Method");
    }
    
    private void privateParentMethod(){
        System.out.println("private parent Method");
    }
    
    
}

public class ForNameReflection extends ParentReflection implements InterfaceReflect{

    protected int a=11,aa;
    public float c;
    private Integer aA;
    public static int b;
    String str="hello";
    
    public ForNameReflection() {
    
        System.out.println("child constructor ForNameReflection class ");  
    }
    
    private void childMethod(){
        System.out.println("child private method");
    }
    
    @Override
    public void interfaceMethod() {
        System.out.println("Interface Public Method");
       
    }
    
  public static void main(String[] args) {
  
      
      Class refClass = null;
      ForNameReflection objFor = null;
      ForNameReflection objNew = new ForNameReflection();
      
      // object creation using forName
      try { 
      System.out.println("----- object creation using forname:");
      refClass   = Class.forName("java7basics.ForNameReflection"); 
      objFor = (ForNameReflection)refClass.newInstance();
      System.out.println("-----object created using forname");
      
    } 
    // handling mulitple catches - Java 1.7 feature
    catch (ClassNotFoundException | InstantiationException | IllegalAccessException e3) {
            e3.printStackTrace();
    } 
      
      System.out.println("parent class public variable" + objFor.dpFloat);
      
      //general class info
      System.out.println("\n Get Class Info\n------------------------");
      System.out.println("getClass - " + objFor.getClass());
      System.out.println("getClassLoader - " + refClass.getClassLoader());
      
        // declared fields
      System.out.println("\n----------------- Fields--------------");
        Field[] f = refClass.getDeclaredFields();
        int i=0;
        for (Field field : f) {
            System.out.println("field " + i +" - " + field);
            i++;
        }
        
        i=0;
        
        // decalred methods
        System.out.println("----------------- Methods--------------");
        Method[] m = refClass.getDeclaredMethods();
        for (Method method : m) {
            System.out.println("method " + i + " - " + method);
            i++;
      }
        
       // get modifier of a field
        System.out.println("----------------- Modifiers--------------");
        for (int j = 0; j < f.length; j++) {
            int mod = f[j].getModifiers();
            System.out.println(" modifier " + j + " - " + Modifier.toString(mod));
            System.out.println(" without toString Caste " + mod);
            
      }
        
    }

    
}
