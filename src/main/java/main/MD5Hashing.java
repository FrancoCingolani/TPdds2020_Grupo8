package main;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hashing {
	
	private static MD5Hashing instance;
	
	private MD5Hashing() {
	}
	
	public static MD5Hashing getInstance() {
		if(instance == null) {
			instance = new MD5Hashing();
		}
		return instance;
	}
	
	public static String getMd5(String pass) 
    { 
		try { 			   
            MessageDigest md = MessageDigest.getInstance("MD5");  
            byte[] messageDigest = md.digest(pass.getBytes()); 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
	
	
}
