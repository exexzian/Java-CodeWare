
package javaexplored.externalizationExample;

import java.io.*;

/***
 * http://www.jusfortechies.com/java/core-java/externalization.php
 */

class BaseOfCar{
    
    public BaseOfCar(){
        System.out.println("in base of car");
    }

}

class CarExternalizable extends BaseOfCar implements Externalizable {
    
    String name;
     transient int year=2000;  // can serialize transient as well as static fields unlike as in Serialisation
    
    /*
     * mandatory public no-arg constructor
     */
    //constructor will b called unlike as in case of Serialization/Deserialization
    public CarExternalizable() {
        System.out.println("in carExternalizable");
    }
    
    CarExternalizable(String n, int y) {
        name = n;
        year = y;
    }
    
    /**
     * Mandatory writeExernal method.
     */
    public void writeExternal(ObjectOutput out) throws IOException  {
        out.writeObject(name);
        out.writeInt(year);
    }
    
    /**
     * Mandatory readExternal method.
     */
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        year = in.readInt();
    }
    
    /**
     * Prints out the fields. used for testing!
     */
    public String toString() {
        return("Name: " + name + "\n" + "Year: " + year);
    }
}

