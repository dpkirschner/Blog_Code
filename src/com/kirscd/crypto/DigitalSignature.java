package com.kirscd.crypto;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class DigitalSignature {
	public static String REAL_DATA = "I will give $200 to charity";
	public static String FAKE_DATA = "I will give $200 to Dan";
	
	private PrivateKey privateKey;
	private PublicKey publicKey;
	
	DigitalSignature() throws NoSuchAlgorithmException, NoSuchProviderException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
		keyGen.initialize(2048);
		
		KeyPair pair = keyGen.generateKeyPair();
		privateKey = pair.getPrivate();
		publicKey = pair.getPublic();
	}
	
	public byte[] sign(String toSign) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
		Signature dsa = Signature.getInstance("SHA1withDSA"); 
		dsa.initSign(privateKey);
		dsa.update(toSign.getBytes(StandardCharsets.UTF_8));
		return dsa.sign();
	}
	
	public boolean verifySignature(String toVerify, byte[] signature) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
		Signature dsa = Signature.getInstance("SHA1withDSA");
		dsa.initVerify(publicKey);
		dsa.update(toVerify.getBytes(StandardCharsets.UTF_8));
		return dsa.verify(signature);
	}
	
	public static void main(String args[]) {
		try {
			DigitalSignature ds = new DigitalSignature();
			byte[] signature = ds.sign(REAL_DATA);
			System.out.println(ds.verifySignature(REAL_DATA, signature));
			System.out.println(ds.verifySignature(FAKE_DATA, signature));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
