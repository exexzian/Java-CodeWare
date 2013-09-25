/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexplored;

/**
 *http://www.dzone.com/links/r/java_immutability_types_weak_and_strong_immutabil.html
 * @author hacker
 */

class Member{
    private int a;
    
    Member(int a){
        this.a = a;
    }
    
    public int getA(){
        return a;
    }
    
    public void setA(int a) {
        this.a=a;
    }
}

class WeakImmutable {
    
    private Member m;
    
    WeakImmutable(WeakImmutable t){
        this.m = t.m;
    }
    
    WeakImmutable(int a){
        m = new Member(a);
    }
    
    public int getMember(){
        return m.getA();
    }
    
    private void setMember(int a){
        this.m.setA(a);
    }
    
    public WeakImmutable modifyM(int a) {
        WeakImmutable t1 = new WeakImmutable(this);
        t1.setMember(a);
        return t1;
    }
}

class StrongImmutable {
    
    private Member m;
    
    StrongImmutable(StrongImmutable t){
        this.m = new Member(t.getMember());
        //this.m = t.m;
    }
    
    StrongImmutable(int a){
        m = new Member(a);
    }
    
    public int getMember(){
        return m.getA();
    }
    
    private void setMember(int a){
        this.m.setA(a);
    }
    
    public StrongImmutable modifyM(int a) {
        StrongImmutable t1 = new StrongImmutable(this);
        t1.setMember(a);
        return t1;
    }
}

public class StrongWeakImmutability {
    public static void main(String[] args) {
        System.out.println("---------------weak immutability----------------");
        WeakImmutable im1  = new WeakImmutable(10);
        System.out.println("Before Modify, im1 member is " + im1.getMember() );
        WeakImmutable im2 = im1.modifyM(20);
        System.out.println("After Modify, im1 member is " + im1.getMember());
        System.out.println("After Modify, im2 member is " + im2.getMember());
        
        System.out.println("\n---------------Strong immutability----------------");
        StrongImmutable im3  = new StrongImmutable(10);
        System.out.println("Before Modify, im3 member is " + im3.getMember());        
        StrongImmutable im4 = im3.modifyM(20);
        System.out.println("After Modify, im3 member is " + im3.getMember());
        System.out.println("After Modify, im4 member is " + im4.getMember());
    }
    

}