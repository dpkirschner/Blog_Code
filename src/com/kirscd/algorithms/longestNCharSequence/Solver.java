package com.kirscd.algorithms.longestNCharSequence;

import java.util.HashMap;


public class Solver {
	
	public static String garbage(String input) {
		if(input.length() == 0) {
			return "";
		}
		
		Character first = input.charAt(0);
		int firstStart = 0;
		int i = 0;
		while(input.charAt(i) == first){
			i++;
			if(i == input.length()) {
				return input;
			}
		}

		Character second = input.charAt(i);
		int secondStart = i;
		i++;
		if(i == input.length()) {
			return input.substring(firstStart);
		}
		while(input.charAt(i) == first || input.charAt(i) == second) {
			i++;
			if(i == input.length()) {
				return input.substring(firstStart, i);
			}
		}
		
		int maxLen = i - firstStart;
		int maxStart = firstStart;
		
		while(i < input.length()) {
			first = second;
			firstStart = secondStart;
			
			second = input.charAt(i);
			secondStart = i;
			
			i++;
			if(i == input.length()) {
				return input.substring(maxStart, maxStart + maxLen);
			}
			while(input.charAt(i) == first || input.charAt(i) == second) {
				i++;
				if(i == input.length()) {
					return input.substring(firstStart, i);
				}
			}
			
			if(firstStart+i > maxLen) {
				maxLen = firstStart+secondStart+i;
				maxStart = firstStart;
			}
		}
		
		return input.substring(maxStart, maxStart + maxLen);
	}
	
	public static String counting(String input) {
		StringBuilder sb = new StringBuilder();
		
		Character current = input.charAt(0);
		int i = 0;
		int count = 0;
		while(i < input.length()) {
			if(input.charAt(i) == current) {
				count++;
				i++;
				continue;
			} 
			
			sb.append(current);
			sb.append(count);
			count = 1;
			current = input.charAt(i);
			i++;
		}
		
		sb.append(current);
		sb.append(count);
		
		return sb.toString();
	}
	
	public static int longestSequenceWithoutRepeats(String input) {
		if(input.isEmpty()) {
			return 0;
		}
		if(input.length() == 1) {
			return 1;
		}
		
		HashMap<Character, Integer> mine = new HashMap<Character, Integer>();
		Character cc = null;
		int maxLen = 0;
		int curLen = 0;
		int i = 0;
		while(i < input.length()) {
			Character current = input.charAt(i);
			if(!mine.containsKey(current)) {
				mine.put(current, i);
				curLen++;
				i++;
				continue;
			}
			
			maxLen = Math.max(maxLen, curLen);
			curLen = curLen - mine.get(current);
			cc = current;
			mine.put(current, i);
			i++;
		}
		
		maxLen = Math.max(maxLen, curLen);
		
		System.out.println(maxLen);
		int start = mine.get(cc);
		for(int j = 0; j < maxLen; j++) {
			System.out.print(input.charAt(start + j));
		}
		return maxLen;
	}
	
	public static void main(String args[]) {
		String input = "abcccbbdddefghhiii";
		
		System.out.println(longestSequenceWithoutRepeats(input));
	}
}
