package com.kirscd.algorithms.utility;

import java.util.HashSet;
import java.util.Random;

public class Utils {
	public static Integer[] buildRandomArray(int size, int lowBound, int highBound) {
		Random r = new Random();
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size() < size) {
			set.add(r.nextInt(highBound - lowBound) + lowBound);
		}

		return set.toArray(new Integer[set.size()]);
	}
	
	public static void printArray(Integer[] values) {
		for(int value : values) {
			System.out.print(value + " : ");
		}
		System.out.println();
	}
	
	public static Integer[] deepCopy(Integer[] values) {
		Integer[] copy = new Integer[values.length];
		for(int i = 0; i < values.length; i++) {
			copy[i] = values[i];
		}
		return copy;
	}
}
