/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advance.java.leap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bingo
 */

 class CustomerID {
  private long crmID;
  private int nameSpace;

  public CustomerID(long crmID, int nameSpace) {
    super();
    this.crmID = crmID;
    this.nameSpace = nameSpace;
  }

  public boolean equals(Object obj) {
    //null instanceof Object will always return false
    if (!(obj instanceof CustomerID))
      return false;
    if (obj == this)
      return true;
    return  this.crmID == ((CustomerID) obj).crmID &&
            this.nameSpace == ((CustomerID) obj).nameSpace;
  }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.crmID ^ (this.crmID >>> 32));
        hash = 79 * hash + this.nameSpace;
        return hash;
    }

  
  

}
public class HashCodeEqualsContract {
    public static void main(String[] args) {
    Map m = new HashMap();
    CustomerID insert = new CustomerID(2345891234L,0);
    m.put(insert,"hello");
    
    CustomerID getter= new CustomerID(2345891234L,0);
    System.out.println(m.get(getter));
  }
}
