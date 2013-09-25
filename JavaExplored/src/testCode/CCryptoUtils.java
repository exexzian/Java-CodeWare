/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * http://cryptofreek.org/2010/06/04/encrypting-and-decrypting-files-with-java/
 * @author hacker
 */
public class CCryptoUtils
{
  public static Cipher createCipher( char[] password,
                                     int nMode,
                                     byte[] baSalt,
                                     int nInterations ) throws NoSuchAlgorithmException,
                                                       InvalidKeySpecException,
                                                       InvalidKeyException,
                                                       InvalidAlgorithmParameterException,
                                                       NoSuchPaddingException
  {
    Cipher cipher = null;

    PBEParameterSpec pbeParamSpec = new PBEParameterSpec( baSalt, nInterations );

    PBEKeySpec pbeKeySpec = new PBEKeySpec( password );
    SecretKeyFactory keyFac = SecretKeyFactory.getInstance( "PBEWithSHA1AndDESede" );
    SecretKey key = keyFac.generateSecret( pbeKeySpec );

    cipher = Cipher.getInstance( "PBEWithSHA1AndDESede" );
    cipher.init( nMode, key, pbeParamSpec );

    return cipher;
  }

  public static void doCrypto( InputStream in, OutputStream out, Cipher cipher ) throws IOException
  {
    CipherOutputStream cos = new CipherOutputStream( out, cipher );
    byte[] baChunck = new byte[128];

    for( int nRead = 0; nRead >= 0; nRead = in.read( baChunck ) )
    {
      cos.write( baChunck, 0, nRead );
    }

    in.close();
    cos.close();
  }

  public static void doFileOperation( File fileIn,
                                      File fileOut,
                                      int nMode,
                                      char[] password,
                                      byte[] baSalt,
                                      int nIterations ) throws InvalidKeyException,
                                                       NoSuchAlgorithmException,
                                                       InvalidKeySpecException,
                                                       InvalidAlgorithmParameterException,
                                                       NoSuchPaddingException,
                                                       FileNotFoundException,
                                                       IOException
  {
    Cipher cipher = createCipher( password, nMode, baSalt, nIterations );
    doCrypto( new FileInputStream( fileIn ),
              new FileOutputStream( fileOut ),
              cipher );
  }

  public static void main( String[] args )
  {
    char[] password = "mypassword".toCharArray();
    byte[] baSalt = "'~7&03~/.".getBytes();
    int nIterations = 1;

    File fileToEncrypt = new File( "D:\\java programs and projects\\Netbeans projects\\JavaExplored\\src\\testCode\\test.txt" );
    File fileEncrypted = new File( "D:\\java programs and projects\\Netbeans projects\\JavaExplored\\src\\testCode\\test.txt.encrypted" );
    File fileDecrypted = new File( "D:\\java programs and projects\\Netbeans projects\\JavaExplored\\src\\testCode\\test.txt.decrypted" );

    try
    {
      doFileOperation( fileToEncrypt,
                       fileEncrypted,
                       Cipher.ENCRYPT_MODE,
                       password,
                       baSalt,
                       nIterations );

      doFileOperation( fileEncrypted,
                       fileDecrypted,
                       Cipher.DECRYPT_MODE,
                       password,
                       baSalt,
                       nIterations );
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }
  }
}