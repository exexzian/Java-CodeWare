/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

import java.lang.ref.*;

class MyObject
{
  protected void finalize() throws Throwable
  {
    System.out.println("In finalize method for this object: " + 
                       this);
  }
}

public class ReferenceUsage
{
  public static void main(String args[])
  {
    hold();
    release();
  }

  public static void hold()
  {
    System.out.println("Example of incorrectly holding a strong " +
                       "reference");
    //Create an object
    MyObject obj = new MyObject();
    System.out.println("object is " + obj);

    //Create a reference queue
    ReferenceQueue rq = new ReferenceQueue();

    //Create a weakReference to obj and associate our reference queue
    WeakReference wr = new WeakReference(obj, rq);

    System.out.println("The weak reference is " + wr);

    //Check to see if it's on the ref queue yet
    System.out.println("Polling the reference queue returns " + 
                       rq.poll());
    System.out.println("Getting the referent from the " +
                       "weak reference returns " + wr.get());
    
    System.out.println("Calling GC");
    System.gc();
    System.out.println("Polling the reference queue returns " + 
                       rq.poll());
    System.out.println("Getting the referent from the " +
                       "weak reference returns " + wr.get());
  }

  public static void release()
  {
    System.out.println("");
    System.out.println("Example of correctly releasing a strong " +
                       "reference");
    //Create an object
    MyObject obj = new MyObject();
   // MyObject obj2 = new MyObject();
    System.out.println("object is " + obj);

    //Create a reference queue
    ReferenceQueue rq = new ReferenceQueue();

    //Create a weakReference to obj and associate our reference queue
    WeakReference wr = new WeakReference(obj, rq);

    System.out.println("The weak reference is " + wr);

    //Check to see if it's on the ref queue yet
    System.out.println("Polling the reference queue returns " + 
                       rq.poll());
    System.out.println("Getting the referent from the " +
                       "weak reference returns " + wr.get());
    
    System.out.println("Set the obj reference to null and call GC");
    obj = null;
    System.gc();
    
    System.out.println("Getting the referent from the " +
                       "weak reference returns " + wr.get());
    System.out.println("Polling the reference queue returns " + 
                       rq.poll());  // weak reference is added to queue after GC has freed memory
  }
}
