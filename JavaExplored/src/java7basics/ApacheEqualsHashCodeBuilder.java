/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

/*
 * http://java.dzone.com/articles/java-hashing
 *

import java.util.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ApacheEqualsHashCodeBuilder {
    
  public static void main(String[] args) {
        Map<ToDos2, String> m = new HashMap<ToDos2, String>();
        ToDos2 t1 = new ToDos2("Monday");
        ToDos2 t2 = new ToDos2("Monday");
        ToDos2 t3 = new ToDos2("Tuesday");
        m.put(t1, "doLaundry");
        m.put(t2, "payBills");
        m.put(t3, "cleanAttic");
        
        System.out.println(m.size());
        System.out.println("get monday " + m.get(t1));
        System.out.println("get monday " + m.get(t2));
        System.out.println("get tuesday " + m.get(t3));
    } 
}

class ToDos2{
    
    String day;
    
    @Override
    public boolean equals(Object obj) {
   //     System.out.println("in equals");
        
        if(obj instanceof ToDos2){
            
            ToDos2 other = (ToDos2) obj;
            EqualsBuilder builder = new EqualsBuilder();
            builder.append(this.day, other.day);
            
            return builder.isEquals();
            
        }
        return false;
    }
    
    @Override
    public int hashCode() {
       // System.out.println("in hashcode");
        HashCodeBuilder builder = new HashCodeBuilder(23, 7);
        builder.append(day);
        
        return builder.toHashCode();
    }
    
    
    
    
    
    ToDos2(String d) { day = d; }
    

}
*/