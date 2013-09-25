/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GcStrCheck {
    
    String str = "hell";
    String str2 = new String("hell");
    static int i;
    transient  static int a=2;
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("string =  " + ++i);
    }
    
    public static void main(String[] args) {
        String mstr = "hell";
        String mstr2 = new String("hell");
        mstr=mstr2=null;
        GcStrCheck obj = new GcStrCheck();
        
        System.out.println(i+"hello");
        Object objstr = new String("bby");
    
        obj.str=obj.str2=null;
        
        obj=null;
        objstr=null;
        
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GcStrCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
