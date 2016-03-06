package com.kirscd.crypto;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SpeechMatching {
	public static String ORIGINAL = "Four score and seven years ago.";
	
	public static String CORRECT_TRANSLATION = "Four score and seven years ago.";
	
	public static String SLIGHTLY_WRONG_TRANSLATION = "Four score and seven years ago";
	
	public static String VERY_WRONG_TRANSLATION = "For scour in six ears a goo.";
	
	public static String hashAlgorithm = "MD5";
	
	
	public static void main(String args[]) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		System.out.println(String.format("'%s' hashes to %032x", ORIGINAL, hashText(ORIGINAL)));
		
		
		System.out.println(String.format("'%s' hashes to %032x", CORRECT_TRANSLATION, hashText(CORRECT_TRANSLATION)));
		System.out.println(String.format("'%s' hashes to %032x", SLIGHTLY_WRONG_TRANSLATION, hashText(SLIGHTLY_WRONG_TRANSLATION)));
		System.out.println(String.format("'%s' hashes to %032x", VERY_WRONG_TRANSLATION, hashText(VERY_WRONG_TRANSLATION)));
	}


	private static BigInteger hashText(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
		md.update(text.getBytes(StandardCharsets.UTF_8));
		return new BigInteger(1, md.digest());
	}
}
