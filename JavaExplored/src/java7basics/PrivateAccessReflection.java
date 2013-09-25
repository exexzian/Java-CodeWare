/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hacker
 */
public class PrivateAccessReflection {
    
    private String privateKey = "Tokyo"; // private field
    
    private void m() {
        System.out.println("hell private");
        
    }

}

class MethodTroubleAgain {
    
    public static void main(String... args) {
        
        PrivateAccessReflection ac = new PrivateAccessReflection();
        
        try {
            Class<?> c = ac.getClass();
            
            Method m = c.getDeclaredMethod("m");
            m.setAccessible(true); // solution
            Object o = m.invoke(ac); // IllegalAccessException
            
            // get the reflected object
            Field field = c.getDeclaredField("privateKey");
            // set accessible true
            field.setAccessible(true);
            System.out.println("Value of privateKey: " + field.get(ac)); // prints "Tokyo"
            // modify the member varaible
            field.set(ac, "Berlin");
            
            System.out.println("Value of privateKey: " + field.get(ac)); // prints "Berlin"
            
            // production code should handle these exceptions more gracefully
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(MethodTroubleAgain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(MethodTroubleAgain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        } catch (InvocationTargetException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        }
    }

}

