/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexplored.externalizationExample;


/**
 * http://www.jusfortechies.com/java/core-java/externalization.php
 */

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

    
/**
 * The superclass does not implement externalizable
 */
class Automobile  {
    
    
     String regNo;
     String mileage;
    
    /* 
     * A public no-arg constructor 
     */
    public Automobile() {}

    Automobile(String rn, String m) {
	regNo = rn;
	mileage = m;
    }
}

 class CarExtrn_BaseClass extends Automobile implements Externalizable {

    String name;
    int year;

    /*
     * mandatory public no-arg constructor
     */
    public CarExtrn_BaseClass() { super(); }
    
    CarExtrn_BaseClass(String n, int y) {
	name = n;
	year = y;
    }

    /** 
     * Mandatory writeExernal method. 
     */
    public void writeExternal(ObjectOutput out) throws IOException  {
	/* 
	 * Since the superclass does not implement the Serializable interface
	 * we explicitly do the saving.
	 */
	out.writeObject(regNo);
	out.writeObject(mileage);
    
	//Now the subclass fields
	out.writeObject(name);
	out.writeInt(year);
    }

    /** 
     * Mandatory readExternal method. 
     */
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
	/* 
	 * Since the superclass does not implement the Serializable interface
	 * we explicitly do the restoring
	 */
	regNo = (String) in.readObject();
	mileage = (String) in.readObject();
	
	//Now the subclass fields
	name = (String) in.readObject();
	year = in.readInt();
    }

    /** 
     * Prints out the fields. used for testing!
     */
    public String toString() {
        return("Reg No: " + regNo + "\n" + "Mileage: " + mileage +
		       "Name: " + name + "\n" + "Year: " + year );
    }
}