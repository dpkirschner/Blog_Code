package com.kirscd.algorithms.numberPairSolver;

import java.util.ArrayList;

public class NaiveSolver extends NumberPairSolver{
	//O(n^2) because you are touching every element for every element
	public boolean solve(ArrayList<Integer> numbers, int target) {
		for(int i = 0; i < numbers.size(); i++) {
			for(int j = i + 1; j < numbers.size(); j++) {
				if(numbers.get(i) + numbers.get(j) == target) {
					return true;
				}
			}
		}
		
		return false;
	}
}
