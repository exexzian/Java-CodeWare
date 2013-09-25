/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

/**
 *
 * @author bingo
 */
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;
 
public class EncryptionExample {
 
      public static void main(String[] args) throws Exception {
 
            // create a key generator based upon the Blowfish cipher
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
 
            // create a key
            SecretKey secretkey = keygenerator.generateKey();
 
            // create a cipher based upon Blowfish
            Cipher cipher = Cipher.getInstance("DES");
 
            // initialise cipher to with secret key
            cipher.init(Cipher.ENCRYPT_MODE, secretkey);
 
            // get the text to encrypt
            String inputText = JOptionPane.showInputDialog("Input your message: ");
 
            // encrypt message
            byte[] encrypted = cipher.doFinal(inputText.getBytes());
 
            // re-initialise the cipher to be in decrypt mode
            cipher.init(Cipher.DECRYPT_MODE, secretkey);
 
            // decrypt message
            byte[] decrypted = cipher.doFinal(encrypted);
          System.out.println("- " + new String(encrypted));
            // and display the results
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                        "Enter text for Encryption: " + new String(encrypted) + "\n"
                                    + "Decryted tag: " + new String(decrypted));
 
            // end example
            System.exit(0);
      }
}
