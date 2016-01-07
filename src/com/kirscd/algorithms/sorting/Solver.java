package com.kirscd.algorithms.sorting;

import com.kirscd.algorithms.utility.Utils;

public class Solver {

	public static void insertion(Integer[] values) {
		for(int i = 1; i < values.length; i++) {
			for(int j = i; j > 0 && values[j-1] > values[j]; j--) {
				swap(values, j, j-1);
			}
		}
	}


	
	public static void quick(Integer[] values, int lower, int upper) {
		if(lower >= upper) {
			return;
		}
		
		int pivot = lower;

		for(int i = pivot+1; i <= upper; i++) {
			if(values[i] <= values[pivot]) {
				swap(values, pivot + 1, i);
				swap(values, pivot + 1, pivot);
				pivot++;
			}
		}
		
		quick(values, lower, pivot-1);
		quick(values, pivot + 1, upper);
	}
	
	public static void main(String args[]) {
		//Integer[] values = Utils.buildRandomArray(11, -100, 100);
		Integer[] values = new Integer[10000];
		for(int i = 0; i < values.length; i++) {
			values[i] = 9;
		}
		//Utils.printArray(values.clone());
		
		
		System.out.println();
		Integer[] copy = Utils.deepCopy(values);
		long start = System.nanoTime();
		insertion(copy);
		long total = System.nanoTime() - start;
		System.out.println("Insertion -> " + total%1000);
		//Utils.printArray(copy);
		
		System.out.println();
		copy = Utils.deepCopy(values);
		start = System.nanoTime();
		quick(copy, 0, copy.length-1);
		total = System.nanoTime() - start;
		System.out.println("Quick -> " + total%1000);
		//Utils.printArray(copy);
	}
	
	/**
	 * @param values
	 * @param j
	 */
	private static void swap(Integer[] values, int posOne, int posTwo) {
		int temp = values[posOne];
		values[posOne] = values[posTwo];
		values[posTwo] = temp;
	}
	
}
