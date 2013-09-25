/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

import javax.swing.JOptionPane;

class PrintName {
    public static void main(String[] args) {

         int nameCount = Integer.parseInt(JOptionPane.showInputDialog(null, " how many NAMES you want to enter?"));
         String [] userFirstName = new String [nameCount];
         String [] userLastName = new String [nameCount];
         for (int i=0; i<nameCount; i++) {
             fullName(userFirstName, userLastName,i);
         }

         for (int i=0; i<nameCount; i++) {
         JOptionPane.showMessageDialog(null, userFirstName[i] + "\n" + userLastName[i]);
    }
    }

    public static void fullName (String[] firstName, String[] nLastName, int i) {
    firstName[i] = JOptionPane.showInputDialog("What's your first name?");
    nLastName[i] = JOptionPane.showInputDialog("What's your last name?");
}

}