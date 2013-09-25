/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

/**
 *
 * @author bingo
 */
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;

public class ReflectionClass {
    
  public static void main(String[] args) throws IllegalAccessException {
    Random r = new Random();
    System.out.print(spyFields(r));
    r.nextInt();
    System.out.println("\nAfter calling nextInt:\n");
    System.out.print(spyFields(r));
  }

  public static String spyFields(Object obj) throws IllegalAccessException {
    StringBuffer buffer = new StringBuffer();
    Field[] fields = obj.getClass().getDeclaredFields();
    for (Field f : fields) {
      if (!Modifier.isStatic(f.getModifiers())) {
        f.setAccessible(true);
        Object value = f.get(obj);
        buffer.append(f.getType().getName());
        buffer.append(" ");
        buffer.append(f.getName());
        buffer.append("=");
        buffer.append("" + value);
        buffer.append("\n");
      }
    }
    return buffer.toString();
  }
}
