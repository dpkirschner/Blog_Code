package com.kirscd.crypto;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProofOfWork {
	public static String hashAlgorithm = "MD5";
	public static String BLOCK_DETAILS = "BLOCK#1 : ";
	public static Character ZERO = '0';
	public static int BEGINNING_ZEROS = 3;
	
	
	public static void main(String args[]) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		Integer nonce = 0;
		String hashValue = hashText(BLOCK_DETAILS, nonce);
		while(!isProofSolved(hashValue)) {
			hashValue = hashText(BLOCK_DETAILS, ++nonce);
		}
		
		System.out.println(String.format("'%s' hashes to %s with a nonce value of %d", BLOCK_DETAILS + nonce, hashValue, nonce));
	}


	private static boolean isProofSolved(String hashValue) {
		for(int i = 0; i < BEGINNING_ZEROS; i++) {
			if(hashValue.charAt(i) != ZERO) {
				return false;
			}
		}
		return true;
	}


	private static String hashText(String text, Integer nonce) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
		md.update(text.getBytes(StandardCharsets.UTF_8));
		md.update(nonce.byteValue());
		return String.format("%032x", new BigInteger(1, md.digest()));
	}
}
