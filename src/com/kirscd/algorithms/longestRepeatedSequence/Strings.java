package com.kirscd.algorithms.longestRepeatedSequence;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Strings {

	public static int naive(String input) {
		int maxLen = 0;
		int thisLen = -1;
		for(int i = 0; i < input.length() - 1; i++) {
			for(int j = i+1; j < input.length() - 1; j++) {
				if((thisLen = comLen(input.substring(i), input.substring(j))) > maxLen) {
					maxLen = thisLen;
				}
			}
		}
		
		return maxLen;
	}
	
	public static String suffix(String input) {
		String[] mine = new String[input.length()];
		for(int i = 0; i < input.length(); i++) {
			mine[i] = input.substring(i);
		}
		
		List<String> yours = Arrays.asList(mine);
		Collections.sort(yours);
		yours.toArray(mine);
		
		int maxLen = 0;
		int thisLen = 0;
		int maxI = 0;
		for(int i = 0; i < mine.length-1; i++) {
			if((thisLen = comLen(mine[i], mine[i+1])) > maxLen) {
				maxLen = thisLen;
				maxI = i;
			}
		}
		return maxLen + " : '" + mine[maxI].substring(0, maxLen) + "'";
	}
	
	private static int comLen(String first, String second) {
		int i = 0;
		while((i <= first.length()-1 && i <= second.length()-1 && first.charAt(i) == second.charAt(i))) {
			i++;
		}
		return i;
	}
	
	public static void main(String args[]) {
		//String input = "ask not what your country can do for you ask what you can do for your country";
		String input = "i";
		System.out.println(naive(input));
		System.out.println(suffix(input));
	}
}
