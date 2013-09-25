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
 * The superclass implements externalizable
 */
class AutomobileExtrn implements Externalizable {
    
    /*
     * Instead of making thse members private and adding setter
     * and getter methods, I am just giving default access specifier.
     * You can make them private members and add setters and getters.
     */
    String regNo;
    String mileage;
    
    /* 
     * A public no-arg constructor 
     */
    public AutomobileExtrn() {}

    AutomobileExtrn(String rn, String m) {
	regNo = rn;
	mileage = m;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
	out.writeObject(regNo);
	out.writeObject(mileage);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        regNo = (String)in.readObject();
        mileage = (String)in.readObject();
    }

}

/***********************************************************************************************/

 class CarBaseExternalizable extends AutomobileExtrn implements Externalizable {

    String name;
    int year;

    /*
     * mandatory public no-arg constructor
     */
    public CarBaseExternalizable() { super(); }
    
    CarBaseExternalizable(String n, int y) {
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