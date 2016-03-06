package com.kirscd.crypto;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DigitalEncryption {
	public static String DATA = "I will give $200 to charity";
	
	private PrivateKey privateKey;
	private PublicKey publicKey;
	
	DigitalEncryption() throws NoSuchAlgorithmException, NoSuchProviderException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		
		KeyPair pair = keyGen.generateKeyPair();
		privateKey = pair.getPrivate();
		publicKey = pair.getPublic();
	}
	
	public byte[] encrypt(String toEncrypt) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("RSA");
	    // encrypt the plain text using the public key
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
	    return cipher.doFinal(toEncrypt.getBytes());
	}
	
	public byte[] decrypt(byte[] toDecrypt) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("RSA");
	    // encrypt the plain text using the public key
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
	    return cipher.doFinal(toDecrypt);
	}
	
	public static void main(String args[]) {
		try {
			DigitalEncryption de = new DigitalEncryption();
			System.out.println("Original value: " + DATA);
			byte[] encrypted = de.encrypt(DATA);
			System.out.println("Encrypted value: " + new String(encrypted));
			byte[] decrypted = de.decrypt(encrypted);
			System.out.println("Decrypted value: " + new String(decrypted));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
