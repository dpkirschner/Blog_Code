package com.kirscd.algorithms.largestSubArray;

import com.kirscd.algorithms.utility.Utils;

public class Solver {

	public static int cubic(Integer[] values) {
		int currentMax = Integer.MIN_VALUE;
		
		for(int i = 0; i < values.length; i++) {
			for(int j = i; j < values.length; j++) {
				//sum from i to j
				int currentSum  = 0;
				for(int k = 0; k < j - i + 1; k++) {
					currentSum += values[i+k];
				}
				currentMax = Math.max(currentMax, currentSum);
			}
		}
		return currentMax;
	}
	
	public static int quadraticOne(Integer[] values) {
		int currentMax = Integer.MIN_VALUE;
		
		for(int i = 0; i < values.length; i++) {
			int currentSum  = 0;
			for(int j = i; j < values.length; j++) {
				//sum from i to j
				currentSum += values[j];
				currentMax = Math.max(currentMax, currentSum);
			}
		}
		return currentMax;
	}
	
	public static int quadraticTwo(Integer[] values) {
		int currentMax = Integer.MIN_VALUE;
		
		for(int i = 0; i < values.length; i++) {
			int currentSum  = 0;
			for(int j = i; j < values.length; j++) {
				//sum from i to j
				currentSum += values[j];
				currentMax = Math.max(currentMax, currentSum);
			}
		}
		return currentMax;
	}

	/**
	 * Does not correctly handle arrays with only negative values.
	 * @param values
	 * @param lower
	 * @param upper
	 * @return
	 */
	public static int subQuadraticOne(Integer[] values, int lower, int upper) {
		if(lower > upper) {
			return 0;
		} 
		if(lower == upper) {
			return Math.max(0, values[lower]);
		}
		
		int midPoint = (lower + upper) / 2;
		
		int lmax = 0;
		int sum = 0;
		
		for(int i = midPoint; i >= lower; i--) {
			sum += values[i];
			lmax = Math.max(lmax, sum);
		}
		
		int rmax = 0;
		sum = 0;
		for(int j = midPoint + 1; j <= upper; j++) {
			sum += values[j];
			rmax = Math.max(rmax, sum);
		}
		
		int x = subQuadraticOne(values, lower, midPoint);
		int y = subQuadraticOne(values, midPoint+1, upper);
		int z = lmax+rmax;
		
		if (x >= y && x>= z)
			return x;
		else if(y >= z && y>= x)
			return y;
		else if (z >= y && z>= x)
			return z;
		return 0;
	}
	
	/**
	 * Does not correctly handle arrays with only negative values.
	 * @param values
	 * @return
	 */
	public static int linear(Integer[] values) {
		if(values.length == 0) {
			return 0;
		}
		int currentMax = 0;
		int maxHere = 0;
		
		for(int i = 0; i < values.length; i++) {
			maxHere = Math.max(maxHere + values[i], values[i]);
			currentMax = Math.max(currentMax, maxHere);
		}
		
		return currentMax;
	}
	
	public static void main(String args[]) {
		Integer[] values = Utils.buildRandomArray(10, -100, 100);
		Utils.printArray(values);
		
		System.out.println("cubic: " + Solver.cubic(values));
		System.out.println("quadraticOne: " + Solver.quadraticOne(values));
		System.out.println("quadraticTwo: " + Solver.quadraticTwo(values));
		System.out.println("subQuadraticOne: " + Solver.subQuadraticOne(values, 0, values.length-1));
		System.out.println("linear: " + Solver.linear(values));
	}
}
