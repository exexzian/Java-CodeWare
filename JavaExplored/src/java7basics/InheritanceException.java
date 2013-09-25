/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;

import java.io.IOException;

class AirPlane {
	public AirPlane() throws IOException, RuntimeException {
		System.out.println("AirPlane");
               
	}
}

 

    
class AirJet extends AirPlane {

    public AirJet() throws IOException, RuntimeException {
    }

} // line 7


    
public class InheritanceException {
public static void main(String args[]) throws IOException { // line 10
	new AirPlane(); // line 11
}    
}
