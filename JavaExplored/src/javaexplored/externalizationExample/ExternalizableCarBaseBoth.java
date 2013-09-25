/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexplored.externalizationExample;

/***
  * http://www.jusfortechies.com/java/core-java/externalization.php
 */


import java.io.*;

public class ExternalizableCarBaseBoth {
   
    public static void main(String args[]) {

	// create a Car object 
	CarBaseExternalizable car = new CarBaseExternalizable("Mitsubishi", 2009);
	CarBaseExternalizable newCar = null;
	
	//serialize the car
	try {
	    FileOutputStream fo = new FileOutputStream("tmp3.exr");
	    ObjectOutputStream so = new ObjectOutputStream(fo);
	    so.writeObject(car);
            so.close();
	    so.flush();
            fo.close();
	} catch (Exception e) {
	    System.out.println(e);
	    System.exit(2);
	}

	// de-serialize the Car
	try (   // try with Resources
            FileInputStream fi = new FileInputStream("tmp3.exr");
	    ObjectInputStream si = new ObjectInputStream(fi);
            ){
	      	    
	    newCar = (CarBaseExternalizable) si.readObject();
	}
	catch (Exception e) {
	    System.out.println(e);
	    System.exit(1);
	}

	/* 
	 * Print out the original and new car information
	 */
	System.out.println("The original car is ");
	System.out.println(car);  // check toString() in CarExtrn_BaseClass
	System.out.println("The new car is ");
        System.out.println(newCar);  // check toString() in CarExtrn_BaseClass
    }
}