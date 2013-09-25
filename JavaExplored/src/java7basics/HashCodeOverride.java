/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

/*
 * http://java.dzone.com/articles/java-hashing
 *

import java.util.*;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class HashCodeOverride {

    public static void main(String[] args) {
        Map<ToDos, String> m = new HashMap<ToDos, String>();
        ToDos t1 = new ToDos("Monday");
        ToDos t2 = new ToDos("Monday");
        ToDos t3 = new ToDos("Tuesday");
        m.put(t1, "doLaundry");
        m.put(t2, "payBills");
        m.put(t3, "cleanAttic");
        System.out.println(m.size());
        System.out.println("get monday " + m.get(t1));
        System.out.println("get monday " + m.get(t2));
        System.out.println("get tuesday " + m.get(t3));
    } 
}

class ToDos{
    
    String day="hello";
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.day);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ToDos other = (ToDos) obj;
        if (!Objects.equals(this.day, other.day)) {
            return false;
            
        }
        return true;
    }
    
    ToDos(String d) { day = d; }
    

}

*/